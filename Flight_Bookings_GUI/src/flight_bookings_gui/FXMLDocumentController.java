package flight_bookings_gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class FXMLDocumentController implements Initializable {
    

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception{
        if(event.getSource() == button){
            makeScene.changeScene(getClass(),event,"managerLogin.fxml");
        }
        if(event.getSource() == button1){
            makeScene.changeScene(getClass(),event,"memberLogin.fxml");
        }
        if(event.getSource() == button2){
            makeScene.changeScene(getClass(),event,"guestController.fxml");
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        button.setCursor(javafx.scene.Cursor.DEFAULT);
        button1.setCursor(javafx.scene.Cursor.DEFAULT);
        button2.setCursor(javafx.scene.Cursor.DEFAULT);
    }

}
