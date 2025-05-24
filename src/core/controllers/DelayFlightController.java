/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.flights.DelayFlight;
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

            if (id.equals("ID")) {
                return new Response("Choose an ID", Status.OK);
            }

            try {
                hourInt = Integer.parseInt(hour);
                if (hour.equals("")) {
                    return new Response("Choose an hour", Status.OK);
                }
            } catch (NumberFormatException ex) {

            }

            try {
                minuteInt = Integer.parseInt(minute);
                if (hour.equals("")) {
                    return new Response("Choose a minute", Status.OK);
                }
            } catch (NumberFormatException ex) {

            }

            for (Flight flight : flights) {
                if (flight.getId().equals(id)) {
                    delayFlight = flight;
                }
            }

            DelayFlight.delay(delayFlight, hourInt, minuteInt);

            return new Response("Flight successfully delayed", Status.OK);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
