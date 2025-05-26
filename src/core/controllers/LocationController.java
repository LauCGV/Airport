/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.LocationStorage;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Laura
 */
public class LocationController {

    public static Response locationRegistration(String id, String name, String city, String country, String latitude, String longitud) {
        LocationStorage locationRegister = LocationStorage.getInstance();
        ArrayList<Location> locations = locationRegister.getLocations();
        try {
            Pattern idPattern = Pattern.compile("^[A-Z]{3}$");
            Pattern latitudPattern = Pattern.compile("^\\d+(\\.\\d{0,4})?$");
            Pattern latitudPattern2 = Pattern.compile("^-?\\d+(\\.\\d{0,4})?$");
            Pattern longitudPattern = Pattern.compile("^\\d+(\\.\\d{0,4})?$");
            Pattern longitudPattern2 = Pattern.compile("^-?\\d+(\\.\\d{0,4})?$");
            double latitudDouble, longitudDouble;
            
            if (!idPattern.matcher(id).matches()) {
                return new Response("Id must be 3 capital letters).", Status.BAD_REQUEST);
            }

            if (locations != null) {
                for (Location location : locations) {
                    if (location.getAirportId() == id) {
                        return new Response("Id in use. Enter another id", Status.BAD_REQUEST);
                    }
                }
            }

            if (name.equals("")) {
                return new Response("Name must be not empty", Status.BAD_REQUEST);
            }

            if (city.equals("")) {
                return new Response("city must be not empty", Status.BAD_REQUEST);
            }

            if (country.equals("")) {
                return new Response("Country must be not empty", Status.BAD_REQUEST);
            }

            try {
                latitudDouble = Double.parseDouble(latitude);
                if (latitudDouble < -90 || latitudDouble > 90) {
                    return new Response("Latitud must be greater than -90 and lees than 90", Status.BAD_REQUEST);
                }
                if (!latitudPattern.matcher(latitude).matches() && !latitudPattern2.matcher(latitude).matches()) {
                    return new Response("Latitude must be less than 5 decimal places.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Latitud must be double", Status.BAD_REQUEST);
            }
            
            try {
                longitudDouble = Double.parseDouble(longitud);
                if (latitudDouble < -180 || latitudDouble > 180) {
                    return new Response("Longitud must be greater than -180 and lees than 180", Status.BAD_REQUEST);
                }
                if ((!longitudPattern.matcher(longitud).matches()) && !longitudPattern2.matcher(longitud).matches()) {
                    return new Response("Longitud must be less than 5 decimal places.", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("Longitud must be double", Status.BAD_REQUEST);
            }

            Location planeTemp = new Location(id, name, city, country, latitudDouble, longitudDouble);
            locations.add(planeTemp);
            return new Response("Location created successfully", Status.CREATED);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
