/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class PassengerStorage implements Storage{
    private static PassengerStorage instance;
    private ArrayList<Passenger> passengers;
    
    private PassengerStorage(){
        this.passengers = new ArrayList();
    }

    public static PassengerStorage getInstance() {
        if(instance == null){
            instance = new PassengerStorage();
        }
        return instance;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
    
    
    @Override
    public void addObject(Object passenger) {
        this.passengers.add((Passenger) passenger);       
    }

}
