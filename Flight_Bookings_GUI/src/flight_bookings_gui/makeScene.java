/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight_bookings_gui;

import javafx.event.Event;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author David
 */
public class makeScene {
    //makeScene.changeScene(getClass(),event,"file");
    public static void changeScene(Class someClass, Event someEvent, String file)throws Exception{
        Parent newScene = FXMLLoader.load(someClass.getResource(file));
        Scene scene = new Scene(newScene);
        Stage stage = (Stage)((Node) someEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
