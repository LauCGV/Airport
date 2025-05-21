/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;


import core.models.Plane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Laura
 */
public class PlaneSort {
    private ArrayList<Plane> planes;
    
    public static ArrayList<Plane> passengers(ArrayList<Plane> planes) {
        Collections.sort(planes, Comparator.comparing(Plane::getId));
       return planes;
    }
}
