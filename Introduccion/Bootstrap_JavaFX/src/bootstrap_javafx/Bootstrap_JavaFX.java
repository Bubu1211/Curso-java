package bootstrap_javafx;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Bootstrap_JavaFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        AnchorPane root = loader.load(getClass().getResourceAsStream("FXML.fxml"));
        
        Scene scene = new Scene(root);
        
        ///recuperamos la hoja de estilos
        String css = Bootstrap_JavaFX.class.getResource("estilos.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
