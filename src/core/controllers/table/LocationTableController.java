/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.table;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Location;
import core.models.storage.LocationStorage;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;


public class LocationTableController {

    public static Response updateLocationTable(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            LocationStorage locationStorage = LocationStorage.getInstance();
            ArrayList<Location> locations = locationStorage.getLocations();

            if (locations == null || locations.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT, locations.clone());
            }

            locations.sort(Comparator.comparing(Location::getAirportId));

            for (Location location : locations) {
                model.addRow(new Object[]{
                    location.getAirportId(),
                    location.getAirportName(),
                    location.getAirportCity(),
                    location.getAirportCountry(),
                });
            }

            return new Response("Data successfully added", Status.OK, locations.clone());
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }

}
