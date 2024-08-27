/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package flight_bookings_gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class MemberLoginController implements Initializable {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
     private void BackManButtonAction(ActionEvent event) throws Exception {
         makeScene.changeScene(getClass(),event,"FXMLDocument.fxml");
     } 
    @FXML
    private void signInAction(ActionEvent event) throws Exception {
    String usernameField = username.getText();
    String passwordField = password.getText();

    if (usernameField.equals("customer") && passwordField.equals("member")) {
        
        makeScene.changeScene(getClass(), event, "memberControls.fxml");
    } else {
    
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Login Error");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect username or password");
        alert.showAndWait();
    }
    }
}
