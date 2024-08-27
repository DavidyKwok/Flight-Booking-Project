/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight_bookings_gui;

/**
 *
 * @author David
 */
public class Flight {
    
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice; 
    private double newPrice;
    public Flight(int flightNumber,String origin,String destination,String departureTime,int capacity,double newPrice){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        numberOfSeatsLeft = capacity;
        this.newPrice = newPrice;
        this.originalPrice = newPrice;
        try{
        if (origin.compareTo(destination)==0){
            throw new IllegalArgumentException("IllegalArgumentException");
  
        }  
        }catch(IllegalArgumentException e){
            System.out.println("Origin and Destination can't be the same");
        }
    }
    
    public int getFlightNumber(){
        return flightNumber;
    }
    
    public String getOrigin(){
        return origin;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String getDepartureTime(){
        return departureTime;
    }
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getNumberOfSeatsLeft(){
        return numberOfSeatsLeft;
    }
    
    public double getOriginalPrice(){
        return originalPrice;
    }
    public double getNewPrice(){
        return newPrice;
    }
    
    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }
    
    public void setOrigin(String origin){
        this.origin = origin;
    }
    
    public void setDestination(String destination){
        this.destination = destination;
    }
    
    public void setDepartureTime(String departureTime){
        this.departureTime = departureTime;
    }
    
    public void setCapacity(int capacity){
        this.capacity = capacity;   
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public void setOriginalPrice(double originalPrice){
        this.originalPrice = originalPrice;
    }
    public void setNewPrice(double newPrice){
        this.newPrice = newPrice;
    }
    
    public boolean bookASeat(){
        if( numberOfSeatsLeft>0){
            numberOfSeatsLeft -=1;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return("Flight"+" "+flightNumber+","+" "+ origin+" "+"to "+destination+" "+departureTime+" :"+newPrice+"$");
    }
    
}

