/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.Passenger;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class PassengerSort {

    private ArrayList<Passenger> passengers;
    
    public static ArrayList<Passenger> passengers(ArrayList<Passenger> passengers) {
        Collections.sort(passengers, Comparator.comparingLong(Passenger::getId));
       return passengers;
    }
}
