/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight_bookings_gui;

/**
 *
 * @author David
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    public static int number;
    
    public Ticket(Passenger p, Flight flight,double price){
        passenger = p;
        this.flight = flight;
        this.price = price;
        number +=1;
    }
    
    public Passenger getPassenger(){
        return passenger;
    }
    
    public Flight getFlight(){
        return flight;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }
    
    public void setFlight (Flight flight){
        this.flight = flight;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    @Override
    
    public String toString(){
        return("Ticket #"+" "+getNumber()+" "+ passenger.getName()+", "+flight.toString()+", ticket price: $"+price);
    }
    
}
    
