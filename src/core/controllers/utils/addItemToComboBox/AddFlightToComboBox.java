/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addItemToComboBox;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.jsonReader.ReadJsonFlight;
import core.models.storage.FlightStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddFlightToComboBox {

    public static Response addItems(JComboBox<String> comboBox) {
        try {
            FlightStorage flightRegister = FlightStorage.getInstance();
            ArrayList<Flight> flights = flightRegister.getFlights();
            comboBox.removeAllItems();
            Collections.sort(flights, Comparator.comparing(Flight::getId));
            comboBox.addItem("Flight");
            for (Flight flight : flights) {
                comboBox.addItem("" + flight.getId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
