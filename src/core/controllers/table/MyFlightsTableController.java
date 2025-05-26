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
import core.models.storage.PassengerStorage;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Laura
 */
public class MyFlightsTableController {

    public static Response updateFlightTable(DefaultTableModel model, String passengerId) {
        try {
            model.setRowCount(0);
            PassengerStorage passengerStorage = PassengerStorage.getInstance();
            ArrayList<Passenger> passengers = passengerStorage.getPassengers();
            Long idLong;
            ArrayList<Flight> flights = new ArrayList<>();

            try {
                idLong = Long.parseLong(passengerId);
            } catch (NumberFormatException ex) {
                return new Response("Choose a user id on administration", Status.BAD_REQUEST, passengers.clone());
            }

            for (Passenger passenger : passengers) {
                if (passenger.getId() == idLong) {
                    flights = passenger.getFlights();
                }
            }

            if (flights == null || flights.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT, flights.clone());
            }

            flights.sort(Comparator.comparing(Flight::getDepartureDate));

            for (Flight flight : flights) {
                model.addRow(new Object[]{
                    flight.getId(),
                    flight.getDepartureDate(),
                    flight.calculateArrivalDate(),});
            }
            
            return new Response("Data successfully added", Status.OK, flights.clone());
        } catch (Exception e) {
            System.out.println(e);
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
