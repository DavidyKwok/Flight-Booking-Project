/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package flight_bookings_gui;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author David
 */
public class GuestControllerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    Manager manager = Flight_Bookings_GUI.manager;

    private String names;
    private int ages;
    private String destinations;
    private String origins;
    private double original;
    public NonMember passenger;
    @FXML
    private Text discount;
    @FXML
    private TextField origin;
    @FXML
    private TextField destination;
     @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private ComboBox<Flight> availableFlights= new ComboBox<>();
    @FXML
    private void readInputAction(ActionEvent event) {
        availableFlights.getItems().clear();
        names = name.getText();
        ages =  Integer.parseInt(age.getText());
        origins = origin.getText();
        destinations = destination.getText();
        passenger = new NonMember(names,ages);
        for(Flight i: manager.flights){
            if(i != null){
            if (i.getOrigin().equals(origins)&& i.getDestination().equals(destinations)){
                i.setNewPrice(passenger.applyDiscount(i.getOriginalPrice()));
                Flight newFlight = i;
                availableFlights.getItems().add(newFlight);
        
            }
        }

        }
        if(passenger.getAge()>65){
           discount.setText("Discount of 10% is applied."); 
        }else{
            for(Flight i:manager.flights){
               if(i != null){ 
                i.setNewPrice(i.getOriginalPrice());
               }
            }
            discount.setText("");
        }
    }  
    
    @FXML
    private void bookFlightAction(ActionEvent event){
        Flight book = availableFlights.getValue();
        if(passenger.getAge()>65){
           manager.getFlight(book.getFlightNumber()).setNewPrice(passenger.applyDiscount(book.getOriginalPrice()));
        }
        switch (manager.bookSeat(book.getFlightNumber(), passenger)) {
            case 0:
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("BOOKED");
               alert.setContentText("Your flight: "+book.toString()+" has been booked.\nYour ticket: "+manager.tickets.get(Ticket.number-1).toString());
               alert.showAndWait(); 
                break;
            case 1:
               Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
               alert1.setTitle("BOOKING FULL");
               alert1.setContentText("The Booking is Full!");
               alert1.showAndWait(); 
                break;
        }
        
    }

    @FXML
    private void logoutAction(ActionEvent event) throws Exception{
         makeScene.changeScene(getClass(),event,"FXMLDocument.fxml");
         Flight_Bookings_GUI.manager = manager;
    }
}
