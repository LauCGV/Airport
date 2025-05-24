/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.flights;

import core.models.Flight;
import core.models.Plane;
import core.models.storage.PlaneStorage;

/**
 *
 * @author Laura
 */
public class AddFlightToPlane {
    public static void addFlight(Plane plane, Flight flight) {
        plane.getFlights().add(flight);
    }
}
