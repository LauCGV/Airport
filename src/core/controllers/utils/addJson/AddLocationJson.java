/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addJson;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.jsonReader.ReadJsonLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddLocationJson {
    public static Response addToComboBox(JComboBox<String> comboBox, JComboBox<String> comboBox2, JComboBox<String> comboBox3) {
        try {
            ReadJsonLocation jsonLocation = new ReadJsonLocation();
            ArrayList<Location> locations = jsonLocation.read("src\\json\\locations.json");
            comboBox.removeAllItems();
            Collections.sort(locations, Comparator.comparing(Location::getAirportId));
            comboBox.addItem("Select Location");
            for (Location location : locations) {
                comboBox.addItem("" + location.getAirportId());
            }
            
            comboBox2.removeAllItems();
            Collections.sort(locations, Comparator.comparing(Location::getAirportId));
            comboBox2.addItem("Select Location");
            for (Location location : locations) {
                comboBox2.addItem("" + location.getAirportId());
            }
            
            comboBox3.removeAllItems();
            Collections.sort(locations, Comparator.comparing(Location::getAirportId));
            comboBox3.addItem("Select Location");
            for (Location location : locations) {
                comboBox3.addItem("" + location.getAirportId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
