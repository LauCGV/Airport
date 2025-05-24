/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addItemToComboBox;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.jsonReader.ReadJsonPassenger;
import core.models.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddPassengerToComboBox {

    public static Response addItems(JComboBox<String> comboBox) {
        try {
            ReadJsonPassenger jsonPassenger = new ReadJsonPassenger();
            ArrayList<Passenger> passengers = jsonPassenger.read("src\\json\\passengers.json");
            comboBox.removeAllItems();
            System.out.println("Size: " + passengers.size());
            Collections.sort(passengers, Comparator.comparingLong(Passenger::getId));
            comboBox.addItem("Select User");
            for (Passenger passenger : passengers) {
                comboBox.addItem("" + passenger.getId());
            }
            return new Response("File upload successfully", Status.CREATED);
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
