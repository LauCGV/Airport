/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addJson;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Passenger;
import core.models.jsonReader.ReadJsonFlight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddFlightJson {

    public static Response addToComboBox(JComboBox<String> comboBox) {
        try {
            ReadJsonFlight jsonFlights = new ReadJsonFlight();
            ArrayList<Flight> flights = jsonFlights.read("src\\json\\flights.json");
            comboBox.removeAllItems();
            Collections.sort(flights, Comparator.comparing(Flight::getId));
            comboBox.addItem("Select Flight");
            for (Flight flight : flights) {
                comboBox.addItem("" + flight.getId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
