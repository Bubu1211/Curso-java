package bootstrap_javafx;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    @FXML
    private JFXButton botonIngresar;
    
    @FXML
    private AnchorPane anchorPane;

    @FXML
    void ingresar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            URL location = PanelPrincipalController.class.getResource("panelPrincipal.fxml");
            loader.setLocation(location);
            BorderPane bp = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Panel principal");
            
            Scene scene = new Scene(bp);
            stage.setScene(scene);
            stage.initOwner(anchorPane.getScene().getWindow()); 
            ((Stage)bp.getScene().getWindow()).close();
            ((Stage)anchorPane.getScene().getWindow()).close();
            stage.show();
            
        } catch (IOException ex) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
