/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flights;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.storage.FlightStorage;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class DelayFlightController {

    public static Response delayFlight(String id, String hour, String minute) {
        try {
            FlightStorage flightRegister = FlightStorage.getInstance();
            ArrayList<Flight> flights = flightRegister.getFlights();
            Flight delayFlight = null;

            int hourInt = 0, minuteInt = 0;

            if (flights == null) {
                return new Response("There are not flights", Status.NO_CONTENT);
            }

            if (id.equals("Flight")) {
                return new Response("Choose an ID", Status.OK);
            }

            try {
                hourInt = Integer.parseInt(hour);
                if (hour.equals("")) {
                    return new Response("Choose an hour", Status.OK);
                }
            } catch (NumberFormatException ex) {
                return new Response("Hour must be numeric", Status.BAD_REQUEST);
            }

            try {
                minuteInt = Integer.parseInt(minute);
                if (hour.equals("")) {
                    return new Response("Choose a minute", Status.OK);
                }
            } catch (NumberFormatException ex) {
                return new Response("Minute must be numeric", Status.BAD_REQUEST);
            }

            for (Flight flight : flights) {
                if (flight.getId().equals(id)) {
                    delayFlight = flight;
                }
            }

            if (delayFlight == null) {
                return new Response("This flight does not exist", Status.BAD_REQUEST);
            }
            
            if(delayFlight.getDepartureDate().plusHours(hourInt).plusMinutes(minuteInt).equals(delayFlight.getDepartureDate())){
                return new Response("Invalid delay time", Status.BAD_REQUEST);
            }
            delayFlight.setDepartureDate(delayFlight.getDepartureDate().plusHours(hourInt).plusMinutes(minuteInt));

            return new Response("Flight successfully delayed", Status.OK);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
