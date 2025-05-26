/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.add;

import core.models.Passenger;
import java.util.ArrayList;

/**
 *
 * @author Cristobal
 */
public class AddPassenger {

    public static boolean addPassengerToList(ArrayList<Passenger> passengers, Passenger passenger) {
        if (!passengers.contains(passenger)) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

}
