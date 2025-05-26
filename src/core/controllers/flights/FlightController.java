/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.flights;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Plane;
import core.models.add.AddFlight;
import core.models.storage.FlightStorage;
import core.models.storage.LocationStorage;
import core.models.storage.PlaneStorage;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Laura
 */
public class FlightController {

    public static Response flightRegistration(String id, String planeString, String departureLocation, String arrivalLocation, String scaleLocation, String departureYear, String departureMonth, String departureDay, String departureHours, String departureMinutes, String arrivalHours, String arrivalMinutes, String scaleHours, String scaleMinutes) {
        FlightStorage flightRegister = FlightStorage.getInstance();
        ArrayList<Flight> flights = flightRegister.getFlights();
        LocationStorage locationRegister = LocationStorage.getInstance();
        ArrayList<Location> locations = locationRegister.getLocations();
        PlaneStorage planeRegister = PlaneStorage.getInstance();
        ArrayList<Plane> planes = planeRegister.getPlanes();
        Plane plane = null;
        Flight flightTemp;
        try {
            Pattern idPattern = Pattern.compile("^[A-Z]{3}\\d{3}$");
            int departureYearInt, arrivalHourInt, arrivalMinuteInt, scaleMinuteInt = 0, scaleHourInt = 0;
            Location locationArrival = null, locationDeparture = null, locationScale = null;
            LocalDateTime departureDate;

            if (!idPattern.matcher(id).matches()) {
                return new Response("Id must be XXXYYY (X corresponds to a capital letter and Y to a digit from 0 to 9).", Status.BAD_REQUEST);
            }

            if (flights != null) {
                for (Flight flight : flights) {
                    if (flight.getId().equals(id)) {
                        return new Response("Id in use. Enter another id", Status.BAD_REQUEST);
                    }
                }
            }

            if (planeString.equals("Plane")) {
                return new Response("Choose a plane", Status.BAD_REQUEST);
            }

            if (planes != null) {
                for (Plane plan : planes) {

                    if (plan.getId().equals(planeString)) {
                        plane = plan;
                    }
                }
            }

            if (departureLocation.equals("Location")) {
                return new Response("Choose a departure location", Status.BAD_REQUEST);
            }

            if (locations != null) {
                for (Location location : locations) {
                    if (location.getAirportId() == departureLocation) {
                        locationDeparture = location;
                    }
                }
            }

            if (arrivalLocation.equals("Location")) {
                return new Response("Choose a arrival location", Status.BAD_REQUEST);
            }

            if (locations != null) {
                for (Location location : locations) {
                    if (location.getAirportId() == arrivalLocation) {
                        locationArrival = location;
                    }
                }
            }

            if (locations != null) {
                for (Location location : locations) {
                    if (location.getAirportId().equals(scaleLocation)) {
                        locationScale = location;
                    }
                }
            }

            try {
                departureYearInt = Integer.parseInt(departureYear);
                if (departureYearInt < 2000) {
                    return new Response("Year must be greater than 2000", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Year must be numeric", Status.BAD_REQUEST);
            }

            try {
                String localDate = String.format("%s-%02d-%02dT%02d:%02d:00", departureYear, Integer.parseInt(departureMonth), Integer.parseInt(departureDay), Integer.parseInt(departureHours), Integer.parseInt(departureMinutes));
                departureDate = LocalDateTime.parse(localDate);
            } catch (DateTimeParseException e) {
                return new Response("Departure date invalid", Status.BAD_REQUEST);
            }

            try {
                arrivalHourInt = Integer.parseInt(arrivalHours);
                if (arrivalHours.equals("Hour")) {
                    return new Response("Select an arrival hour", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Select an arrival hour", Status.BAD_REQUEST);
            }

            try {
                arrivalMinuteInt = Integer.parseInt(arrivalMinutes);
                if (arrivalMinutes.equals("Minute")) {
                    return new Response("Select an arrival minute", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Select an arrival minute", Status.BAD_REQUEST);
            }

            if (departureDate.plusHours(arrivalHourInt).plusMinutes(arrivalMinuteInt).equals(departureDate)) {
                return new Response("Time of flight must be greater that 0", Status.BAD_REQUEST);
            }

            System.out.println("Scale: " + locationScale);

            if (locationScale != null && scaleHours.equals("Hour")) {
                try {
                    scaleHourInt = Integer.parseInt(scaleHours);
                } catch (NumberFormatException ex) {
                    return new Response("Select a scale hour", Status.BAD_REQUEST);
                }

            }

            if (locationScale != null && scaleMinutes.equals("Minute")) {
                try {
                    scaleMinuteInt = Integer.parseInt(scaleMinutes);
                } catch (NumberFormatException ex) {
                    return new Response("Select a scale minute", Status.BAD_REQUEST);
                }
            }

            if (locationScale == null) {
                flightTemp = new Flight(id, plane, locationDeparture, locationArrival, departureDate, arrivalHourInt, arrivalMinuteInt);
            } else {
                flightTemp = new Flight(id, plane, locationDeparture, locationScale, locationArrival, departureDate, arrivalHourInt, arrivalMinuteInt, scaleHourInt, scaleMinuteInt);
            }

            flights.add(flightTemp);
            AddFlight.addFlightToList(plane.getFlights(), flightTemp);

            return new Response("Flight created successfully", Status.CREATED);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
