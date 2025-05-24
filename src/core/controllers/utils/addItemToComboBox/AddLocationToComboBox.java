/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addItemToComboBox;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.jsonReader.ReadJsonLocation;
import core.models.storage.LocationStorage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddLocationToComboBox {

    public static Response addItems(JComboBox<String> comboBox) {
        try {
            LocationStorage locationRegister = LocationStorage.getInstance();
            ArrayList<Location> locations = locationRegister.getLocations();
            comboBox.removeAllItems();
            Collections.sort(locations, Comparator.comparing(Location::getAirportId));
            comboBox.addItem("Location");
            for (Location location : locations) {
                comboBox.addItem("" + location.getAirportId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
