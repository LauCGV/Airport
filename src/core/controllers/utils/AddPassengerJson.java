/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.JsonReaders.ReadJsonPassenger;
import core.models.Passenger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Laura
 */
public class AddPassengerJson {

    public static Response addToComboBox(JComboBox<String> comboBox){
      //  try {

            ReadJsonPassenger jsonPassenger = new ReadJsonPassenger();
            ArrayList<Passenger> passengers = jsonPassenger.read("src\\json\\passengers.json");
            comboBox.removeAllItems();
            Collections.sort(passengers, Comparator.comparingLong(Passenger::getId));
            comboBox.addItem("Select User");
            for (Passenger passenger : passengers) {
                comboBox.addItem("" + passenger.getId());
                System.out.println("New: " + passenger.getId());
            }

      /*  } catch (FileNotFoundException ex) {
            return new Response("File not found", Status.NOT_FOUND);
        } catch (EOFException ex) {
            return new Response("File empty", Status.NO_CONTENT);
        }*/

        return new Response("File upload successfully", Status.CREATED);

    }
}
