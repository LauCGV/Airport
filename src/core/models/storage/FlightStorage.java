/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.Flight;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class FlightStorage extends Storage {
   private static FlightStorage instance;
    private ArrayList<Flight> flights;
    
    private FlightStorage(){
        this.flights = new ArrayList();
    }

    public static FlightStorage getInstance() {
        if(instance == null){
            instance = new FlightStorage();
        }
        return instance;
    }

    public ArrayList<Flight> getFlights() {
        return this.flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
    
    
   @Override
    public void addObject(Object flight) {
        this.flights.add((Flight) flight);       
    } 
}
