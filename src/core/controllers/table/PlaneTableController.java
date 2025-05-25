/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.table;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.PlaneStorage;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

public class PlaneTableController {


    public static Response updatePlaneTable(DefaultTableModel model) {
        try {
            model.setRowCount(0);
            PlaneStorage planeStorage = PlaneStorage.getInstance();
            ArrayList<Plane> planes = planeStorage.getPlanes();

            if (planes == null || planes.isEmpty()) {
                return new Response("The list is empty.", Status.NO_CONTENT, planes.clone());
            }

            planes.sort(Comparator.comparing(Plane::getId));

            for (Plane plane : planes) {
                model.addRow(new Object[]{
                    plane.getId(),
                    plane.getBrand(),
                    plane.getModel(),
                    plane.getMaxCapacity(),
                    plane.getAirline(),
                    plane.getNumFlights()
                });
            }

            return new Response("Data successfully added", Status.OK, planes.clone());
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
