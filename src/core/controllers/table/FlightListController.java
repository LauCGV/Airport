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

/**
 *
 * @author Allison Ruiz
 */
public class FlightListController {

    public static Response updateFlightList(DefaultTableModel model) {
        try {
            model.setRowCount(0); // Limpiar el modelo
            FlightStorage flightStorage = FlightStorage.getInstance();
            ArrayList<Flight> flights = flightStorage.getFlights();

            if (flights == null || flights.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT);
            }

            // Ordenar por Fecha de salida ascendente
            flights.sort(Comparator.comparing(Flight::getDepartureDate));

            for (Flight flight : flights) {
                model.addRow(new Object[]{
                    flight.getId(),
                    flight.getDepartureLocation().getAirportId(),
                    flight.getArrivalLocation().getAirportId(),
                    flight.getScaleLocation().getAirportId(),
                    flight.getDepartureDate(),
                    flight.calculateArrivalDate(),
                    flight.getPlane().getId(),
                    flight.getNumPassengers(),});
            }

            return new Response("List updated successfully.", Status.OK);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
