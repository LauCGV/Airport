/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addItemToComboBox;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.jsonReader.ReadJsonPlane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddPlaneToComboBox {
   public static Response addItems(JComboBox<String> comboBox) {
        try {
            ReadJsonPlane jsonPlanes = new ReadJsonPlane();
            ArrayList<Plane> planes = jsonPlanes.read("src\\json\\planes.json");
            comboBox.removeAllItems();
            Collections.sort(planes, Comparator.comparing(Plane::getId));
            comboBox.addItem("Plane");
            for (Plane plane : planes) {
                comboBox.addItem("" + plane.getId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected", Status.INTERNAL_SERVER_ERROR);
        }
    } 
}
