package flvst.view;

import flvst.controller.Calculo;
import flvst.model.datos.DML;
import flvst.model.domain.EstudianteDTO;
import flvst.model.main.ConnBD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class ViewController implements Initializable {

    //dclaramos atributos para usarlos como referencias a los elementos en el .fxml
    //el nombre del controlador debe ser el mismo que en el xml
    @FXML
    TextField textNombre, textApellido, textPromedio;
    @FXML
    Label labelTitulo, labelNombre, labelApellido, labelPromedio;
    @FXML
    Button btnRegistrar, btnModificar, btnEliminar;
    Button btnGraficar;

    @FXML
    TableView<EstudianteDTO> tablaRegistros; //Elementos para la tabla
    @FXML
    TableColumn<EstudianteDTO, Integer> columnaIdEstudiante;
    @FXML
    TableColumn<EstudianteDTO, String> columnaNombre;
    @FXML
    TableColumn<EstudianteDTO, String> columnaApellido;
    @FXML
    TableColumn<EstudianteDTO, Double> columnaPromedio;
    @FXML
    TableColumn<EstudianteDTO, Double> columnaEstado;
    @FXML
    GridPane gridPanel;
    @FXML
    AnchorPane panelGrafica;

    ConnBD conexion;
    ObservableList<EstudianteDTO> estudiantes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //indica a la columna el valor de la celda = propiedad de la clase del observableList
        columnaIdEstudiante = new TableColumn<>("Id estudiante");
        columnaNombre = new TableColumn<>("Nombre");
        columnaApellido = new TableColumn<>("Apellido");
        columnaPromedio = new TableColumn<>("Promedio");
        columnaEstado = new TableColumn<>("Estado");

        columnaIdEstudiante.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getIdEstudiante()));
        columnaNombre.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNombre()));
        columnaApellido.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getApellido()));
        columnaPromedio.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPromedio()));
        columnaEstado.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getPromedio()));

        columnaEstado.setCellFactory(new Callback<TableColumn<EstudianteDTO, Double>, TableCell<EstudianteDTO, Double>>() {
            @Override
            public TableCell<EstudianteDTO, Double> call(TableColumn<EstudianteDTO, Double> tablecolumn) {
                return new TableCell<EstudianteDTO, Double>() {
                    @Override
                    protected void updateItem(Double item, boolean empty) {
                        if (item != null) {
                            if (item.doubleValue() >= 7.5) {
                                setStyle("-fx-background-color: green");
                            } else if (item.doubleValue() < 7.5 && item.doubleValue() >= 6.5) {
                                setStyle("-fx-background-color: yellow");
                            } else if (item.doubleValue() < 6.5) {
                                setStyle("-fx-background-color: red");
                            }
                        }
                    }
                };
            }
        });

        this.tablaRegistros.getColumns().add(columnaIdEstudiante);
        this.tablaRegistros.getColumns().add(columnaNombre);
        this.tablaRegistros.getColumns().add(columnaApellido);
        this.tablaRegistros.getColumns().add(columnaPromedio);
        this.tablaRegistros.getColumns().add(columnaEstado);

        conexion = new ConnBD();
        estudiantes = FXCollections.observableArrayList(conexion.getEstudiantes());
        this.tablaRegistros.setItems(estudiantes);
        this.tablaRegistros.refresh();
    }

    @FXML
    void guardar(ActionEvent e) {
        String nombre = this.textNombre.getText();
        String apellido = this.textApellido.getText();
        String textPromedio = this.textPromedio.getText();

        if (!nombre.equals("") || !apellido.equals("") || !textPromedio.equals("")) {
            double promedio = Double.parseDouble(textPromedio);
            EstudianteDTO estudiante = new EstudianteDTO(nombre, apellido, promedio);

            conexion.solicitud(DML.INSERT, estudiante);
            refreshTabla();

            alertInfo("Estudiante agregado");
        } else {
            alertError("Celdas vacías, inserte valores validos por favor");
        }

    }

    @FXML
    void seleccionar(MouseEvent e) {
        //selecciona la celda que se pica con el mouse, retorna un objeto con l clase espcificada
        EstudianteDTO estudiante = this.tablaRegistros.getSelectionModel().getSelectedItem();

        if (estudiante != null) {
            this.textNombre.setText(estudiante.getNombre());
            this.textApellido.setText(estudiante.getApellido());
            this.textPromedio.setText(String.valueOf(estudiante.getPromedio()));
        } else {
            alertError("error al seleccionar");
        }
    }

    @FXML
    void modificar(ActionEvent e) {
        EstudianteDTO estudiante = this.tablaRegistros.getSelectionModel().getSelectedItem();
        if (estudiante == null) {
            alertError("Error en la selección, seleccione un usuario");
        } else {

            String nombre = this.textNombre.getText();
            String apellido = this.textApellido.getText();
            double promedio = Double.parseDouble(this.textPromedio.getText());

            EstudianteDTO estudiante2 = new EstudianteDTO(estudiante.getIdEstudiante(), nombre, apellido, promedio);

            conexion.solicitud(DML.UPDATE, estudiante2);
            refreshTabla();
            alertInfo("Estudiante modificado");
        }
    }

    @FXML
    void eliminar(ActionEvent e) {
        EstudianteDTO estudiante = this.tablaRegistros.getSelectionModel().getSelectedItem();
        if (estudiante == null || this.textNombre.getText().equals("") || this.textApellido.getText().equals("") || this.textPromedio.getText().equals("")) {
            alertError("Celdas y selección nula");
        } else {
            conexion.solicitud(DML.DELETE, estudiante);
            refreshTabla();
            alertInfo("estudiante eliminado");
        }
    }

    @FXML
    public void pintarGraficas(ActionEvent e) {
        panelGrafica.getChildren().clear();
        System.out.println("Graficar");
        List<EstudianteDTO> estudiantes = conexion.getEstudiantes();
        
        double menor = Calculo.getPromedioMenor(estudiantes);
        double mayor = Calculo.getPromedioMayor(estudiantes);

        CategoryAxis x = new CategoryAxis();       ///instanciamos la gráfica y sus ejes
        NumberAxis y = new NumberAxis(menor-1, mayor, 0.5);
        LineChart lineChart = new LineChart<String, Number>(x, y);

        //creamos la serie que contiene los datos de la gráfica
        XYChart.Series series = new XYChart.Series();
        XYChart.Series serieLimiteAprobado = new XYChart.Series();
        XYChart.Series serieLimiteRiesgo = new XYChart.Series();

        series.setName("Calificaciones"); //nombre de la serie
        serieLimiteAprobado.setName("Aprobatorio");
        serieLimiteRiesgo.setName("En riesgo");

        

        estudiantes.forEach(i -> {
            series.getData().add(new XYChart.Data(i.getNombre(), i.getPromedio()));
            serieLimiteAprobado.getData().add(new XYChart.Data(i.getNombre(), 7.5));
            serieLimiteRiesgo.getData().add(new XYChart.Data(i.getNombre(), 6.5));
        });

        lineChart.setCreateSymbols(false);
        //pasamos la serie a la grafica
        lineChart.getData().add(series);
        lineChart.getData().add(serieLimiteAprobado);
        lineChart.getData().add(serieLimiteRiesgo);

        //gridPanel.add(lineChart, 1, 0);
        panelGrafica.getChildren().add(lineChart);
    }

    public void refreshTabla() {
        tablaRegistros.setItems(FXCollections.observableArrayList(conexion.getEstudiantes()));
        this.tablaRegistros.refresh();
    }

    public void alertError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void alertInfo(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
