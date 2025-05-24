/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.flights;

import core.models.Flight;
import core.models.Passenger;
import core.models.storage.FlightStorage;
import core.models.storage.PassengerStorage;

/**
 *
 * @author Laura
 */
public class AddFlightToPassenger {

    public static void addFlight(Passenger passengerSelected,Flight flightSelected) {
        passengerSelected.getFlights().add(flightSelected);
    }
}
