/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight_bookings_gui;

/**
 *
 * @author David
 */
public class NonMember extends Passenger {
    public NonMember(String name, int age){
        super(name,age);
    }
    @Override
    public double applyDiscount(double p){
        if (age>65){
            p = p-(p*0.1);
        }
        return p;
    }
    
}