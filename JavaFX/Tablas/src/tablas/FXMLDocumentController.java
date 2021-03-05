package tablas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {

    @FXML
    TableView tabla;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Dog> perros = new ArrayList<Dog>();
        
        List<Vacuna> v1 = new ArrayList<>();
        v1.add(new Vacuna(true, "Parvovrus"));
        
        perros.add(new Dog(9, "Chato", new Owner("Estroncio", "Julio"), v1));
        perros.add(new Dog(11, "Jade", new Owner("Geovillas", "Mariel"), v1));

        ObservableList perrosTabla = FXCollections.observableArrayList(perros);

        TableColumn<Dog, String> columna1 = new TableColumn<>("Nombre");
        TableColumn<Dog, Integer> columna2 = new TableColumn<>("Edad");
        TableColumn<Dog, String> columna3 = new TableColumn<>("NombreDueño");
        TableColumn<Dog, String> columna4 = new TableColumn<>("Dirección del dueño");

        columna1.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getNombre()));
        columna2.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getEdad()));
        columna3.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getOwner().getNombre()));
        columna4.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getOwner().getDireccion()));


        tabla.getColumns().add(columna1);
        tabla.getColumns().add(columna2);
        tabla.getColumns().add(columna3);
        tabla.getColumns().add(columna4);
        
        tabla.setItems(perrosTabla);

    }
    

}
