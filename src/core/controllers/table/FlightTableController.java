/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.table;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.storage.FlightStorage;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

public class FlightTableController {

    public static Response updateFlightTable(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            FlightStorage flightStorage = FlightStorage.getInstance();
            ArrayList<Flight> flights = flightStorage.getFlights();

            if (flights == null || flights.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT);
            }

            flights.sort(Comparator.comparing(Flight::getDepartureDate));

            for (Flight flight : flights) {
                if (flight.getScaleLocation() != null) {
                    model.addRow(new Object[]{
                        flight.getId(),
                        flight.getDepartureLocation().getAirportId(),
                        flight.getArrivalLocation().getAirportId(),
                        flight.getScaleLocation().getAirportId(),
                        flight.getDepartureDate(),
                        flight.calculateArrivalDate(),
                        flight.getPlane().getId(),
                        flight.getNumPassengers(),});
                } else {
                    model.addRow(new Object[]{
                        flight.getId(),
                        flight.getDepartureLocation().getAirportId(),
                        flight.getArrivalLocation().getAirportId(),
                        (Object) "no aply",
                        flight.getDepartureDate(),
                        flight.calculateArrivalDate(),
                        flight.getPlane().getId(),
                        flight.getNumPassengers(),});
                }
            }
            return new Response("Data successfully added", Status.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
