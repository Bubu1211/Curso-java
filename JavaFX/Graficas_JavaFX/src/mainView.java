/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class mainView extends Application {

    @Override
    public void start(Stage primaryStage) {

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

        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResourceAsStream("Panel.fxml"));
            FXMLLoader loaderDos = new FXMLLoader();
            LineChart graph = loaderDos.load(getClass().getResourceAsStream("vistaGrafica.fxml"));

            root.getChildren().add(graph);
            Scene scene = new Scene(root, 800, 500);

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
