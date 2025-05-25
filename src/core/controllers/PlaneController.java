/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Plane;
import core.models.storage.PlaneStorage;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Laura
 */
public class PlaneController {

    public static Response planeRegistration(String id, String brand, String model, String maxCapacity, String airline) {
        PlaneStorage planeRegister = PlaneStorage.getInstance();
        ArrayList<Plane> planes = planeRegister.getPlanes();
        try {
            Pattern idPattern = Pattern.compile("^[A-Z]{2}\\d{5}$");
            int maxCapInt;
            
            if (id.equals("")) {
                return new Response("Id must be not empty", Status.BAD_REQUEST);
            }
            
            if (brand.equals("")) {
                return new Response("Brand must be not empty", Status.BAD_REQUEST);
            }

            if (model.equals("")) {
                return new Response("Model must be not empty", Status.BAD_REQUEST);
            }
            
            if (!idPattern.matcher(id).matches()) {
                return new Response("Id must be XXYYYYY (X corresponds to a capital letter and Y to a digit from 0 to 9).", Status.BAD_REQUEST);
            }

            if (planes != null) {
                for (Plane plane : planes) {
                    if (plane.getId() == id) {
                        return new Response("Id in use. Enter another id", Status.BAD_REQUEST);
                    }
                }
            }

            try {
                maxCapInt = Integer.parseInt(maxCapacity);
                if (maxCapInt < 0) {
                    return new Response("MaxCapacity must be a positive", Status.BAD_REQUEST);
                }
            } catch (NumberFormatException ex) {
                return new Response("MaxCapacity must be numeric", Status.BAD_REQUEST);
            }

            if (airline.equals("")) {
                return new Response("Airline must be not empty", Status.BAD_REQUEST);
            }
            Plane planeTemp = new Plane(id, brand, model, maxCapInt, airline);
            planes.add(planeTemp);
            return new Response("Plane created successfully", Status.CREATED);

        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
