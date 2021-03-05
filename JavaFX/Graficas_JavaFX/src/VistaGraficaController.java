
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class VistaGraficaController implements Initializable {

    @FXML
    LineChart<Number, Number> lineChart;
    @FXML
    NumberAxis x;
    @FXML
    NumberAxis y;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }
    
    public void pintar(){
        NumberAxis x = new NumberAxis("Eje x", -50, 50, 2);       ///instanciamos la gráfica y sus ejes
        NumberAxis y = new NumberAxis("Eje y", -2.5, 2.5, 1);
        LineChart lineChart = new LineChart<Number, Number>(x, y);

        //creamos la serie que contiene los datos de la gráfica
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio"); //nombre de la serie
        
        for(double i=-50 ; i<=50; i+=1.0){
            series.getData().add(new XYChart.Data(i, Math.sin(i)));
        }
        
        lineChart.setCreateSymbols(false);
        //pasamos la serie a la grafica
        lineChart.getData().add(series);
    }
}
