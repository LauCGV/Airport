/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.Location;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class LocationSort {
    private ArrayList<Location> locations;
    
    public static ArrayList<Location> locations(ArrayList<Location> locations) {
        Collections.sort(locations, Comparator.comparing(Location::getAirportId));
       return locations;
    }
}
