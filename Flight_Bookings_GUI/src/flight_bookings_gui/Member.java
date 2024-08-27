/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight_bookings_gui;

/**
 *
 * @author David
 */
public class Member extends Passenger {
        public int yearsOfMembership;
        
    
        public Member(String name, int age,int yearsOfMembership){
                super(name,age);
                this.yearsOfMembership = yearsOfMembership;   
            }

        @Override
        public double applyDiscount(double p){
            if (yearsOfMembership>5){
                p*=0.5;
            }
            else if(yearsOfMembership>1 && yearsOfMembership<=5){
                p = p-(p*0.1);
            }
            return p;
        }
    
}

