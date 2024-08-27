
package flight_bookings_gui;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class Manager {
    public ArrayList<Flight> flights;
    public ArrayList<Ticket> tickets;
    public Manager(){
        this.flights = new ArrayList<Flight>();
        this.tickets = new ArrayList<Ticket>();
    }
    public void createFlights(int flightNumber, String origin, String destination, String departure, int capacity, double price){
        flights.add(new Flight(flightNumber,origin,destination,departure,capacity,price));
    }
    
    public void displayAvailableFlights(String origin, String destination){
        for(Flight i:flights){
        if (i.getNumberOfSeatsLeft()!= 0 && i.getOrigin().compareTo(origin)== 0 && i.getDestination().compareTo(destination)==0){
            System.out.println(i.toString());
        }
            }
    }
    
    public Flight getFlight(int flightNumber){
        for(Flight i:flights){
            if(i.getFlightNumber()== flightNumber){
                return (i);
            }
        }
     return (null);   
    }
    
    public int bookSeat(int flightNumber, Passenger p){
        if(getFlight(flightNumber) != null){
           if(getFlight(flightNumber).bookASeat()){
               double price = p.applyDiscount(getFlight(flightNumber).getOriginalPrice());
               Ticket t=new Ticket(p,getFlight(flightNumber),price);
               tickets.add(t);
               System.out.println("Your ticket:"+" "+ t.toString());
               return(0);
           }else{
               System.out.println("Booking is full!");
               return(1);
           }
        }else{
            System.out.println("Flight Number doesn't exist");
            return(2);
        }
        
    }

/*
    public static void main(String[] args) {
        Manager m = new Manager();
        Member p1 = new Member("Bob",27,10);
        Member p2 = new Member("Tracy",34,4);
        Member p3 = new Member("John",37,1);
        NonMember p4 = new NonMember ("Richard",25);
        NonMember p5 = new NonMember ("Rachel",80);
        m.createFlights();
        m.displayAvailableFlights("Toronto", "New York");
        m.displayAvailableFlights("Toronto","Kolkata");
        m.bookSeat(1030, p1);// 50% discount because years of membership is greater than 5
        m.bookSeat(1030, p2);// 10% discount because years of membership is between 1 and 5
        m.bookSeat(1030,p3);// no discount because years of membership is less than 1
        m.bookSeat(1030,p4);// Prints Booking is full because the capacity has been reached
        m.bookSeat(1031,p4);//Prints Flight Number doesn't exist because 1031 doesn't exist
        m.bookSeat(1040, p4);// no discount because non member
        m.bookSeat(1040,p5);// 10% dicount because they are non member and above the age of 60
        
       
        
        
    }
*/
}
