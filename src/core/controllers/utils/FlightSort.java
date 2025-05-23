/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.Flight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class FlightSort {
    private ArrayList<Flight> flights;
    
    public static ArrayList<Flight> flightsSort(ArrayList<Flight> flights) {
        Collections.sort(flights, Comparator.comparing(Flight::getId));
       return flights;
    }
}
