/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flights;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.storage.FlightStorage;
import core.models.storage.PassengerStorage;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class AddFlightToPassengerController {

    public static Response addFlight(String id, String idFlight) {
        PassengerStorage passengerRegister = PassengerStorage.getInstance();
        ArrayList<Passenger> passengers = passengerRegister.getPassengers();
        FlightStorage flightRegister = FlightStorage.getInstance();
        ArrayList<Flight> flights = flightRegister.getFlights();
        Passenger passengerSelected = null;
        Flight flightSelected = null;
        try {
            long idPassenger;
            try {
                idPassenger = Long.parseLong(id);
            } catch (NumberFormatException ex) {
                return new Response("Select a passenger on administration", Status.BAD_REQUEST);
            }
            if (passengers.isEmpty()) {
                return new Response("No passengers available", Status.BAD_REQUEST);
            }

            if (flights.isEmpty()) {
                return new Response("No flights available", Status.BAD_REQUEST);
            }

            for (Passenger passenger : passengers) {
                if (passenger.getId() == idPassenger) {
                    passengerSelected = passenger;
                }
            }

            if (idFlight.equals("Flight")) {
                return new Response("Select a flight", Status.BAD_REQUEST);
            }

            if (flights.isEmpty()) {
                return new Response("No flights available", Status.BAD_REQUEST);
            }

            for (Flight flight : flights) {
                if (flight.getId().equals(idFlight)) {
                    flightSelected = flight;
                }
            }

            if (passengerSelected.getFlights().contains(flightSelected)) {
                return new Response("This flight already exist on this passenger", Status.BAD_REQUEST);
            }

            flightSelected.getPassengers().add(passengerSelected);
            passengerSelected.getFlights().add(flightSelected);

            return new Response("Flight added successfully", Status.OK);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
