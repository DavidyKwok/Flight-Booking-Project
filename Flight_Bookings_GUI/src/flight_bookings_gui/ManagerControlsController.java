/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package flight_bookings_gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author David
 */
public class ManagerControlsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Flight i: manager.flights){
            if (i != null){
                flightBox.getItems().add(i);
            }
        }
       
    }  
    @FXML
    private TextField flightNumber;
    @FXML
    private TextField origin;
    @FXML
    private TextField destination;
    @FXML
    private TextField departure;
    @FXML
    private TextField capacity;
    @FXML
    private TextField price;
    @FXML
    private Button createFlight;
    @FXML
    private ComboBox<Flight> flightBox= new ComboBox<>();
    protected String origins,destinations,departures;
    protected int flightNumbers,capacitys;
    protected double prices;
    private Manager manager = Flight_Bookings_GUI.manager;
    @FXML
    private void createFlightAction(ActionEvent event) throws Exception {
        try{
        if (event.getSource() == createFlight) {
            flightNumbers = Integer.parseInt(flightNumber.getText());
            origins = origin.getText();
            destinations = destination.getText();
            departures = departure.getText();
            capacitys = Integer.parseInt(capacity.getText());
            prices = Double.parseDouble(price.getText());
            if(origin.getText().equals(destination.getText())){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("ERROR");
               alert.setContentText("Origin and Destination can't be the same!");
               alert.showAndWait(); 
            }else{
            manager.createFlights(flightNumbers, origins, destinations, departures, capacitys, prices);
            Flight newFlight = manager.getFlight(flightNumbers);
            flightBox.getItems().add(newFlight);
            if(origin.getText().isEmpty()||flightNumber.getText().isEmpty()||destination.getText().isEmpty()||departure.getText().isEmpty()||capacity.getText().isEmpty()||price.getText().isEmpty()){
                throw new Exception();
            }
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Confirmation");
              alert.setContentText("The flight "+newFlight.toString()+" has been created");
              alert.showAndWait();
            }
        }

        }catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setContentText("Make sure Capacity, Price, and Flight Number isn't a string \n and all fields are filled in.");
        alert.showAndWait();
            }
        }
    
   @FXML
    private void deleteFlightAction(ActionEvent event) {
        Flight delete = flightBox.getValue();
        for (Flight i : manager.flights) {
            if (delete == i) {
                manager.flights.remove(i);
                break;
            }
        }
       
        flightBox.getItems().remove(delete);
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Confirmation");
              alert.setContentText("The flight "+delete.toString()+" has been deleted.");
              alert.showAndWait();
    }
    @FXML
    private void displayFlightsAction(ActionEvent event){
        String text = "Created Flights:\n";
        for(Flight i: manager.flights){
           if (i != null) {  
          text+=i.toString();
          text+="\n";
           }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Display Flights");
        alert.setContentText(text);
        alert.showAndWait();
    }
    @FXML
    private void logoutAction(ActionEvent event) throws Exception{
        makeScene.changeScene(getClass(),event,"FXMLDocument.fxml");
        Flight_Bookings_GUI.manager.flights = manager.flights;
    }
    
}
