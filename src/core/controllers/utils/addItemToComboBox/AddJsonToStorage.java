/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils.addItemToComboBox;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Flight;
import core.models.Location;
import core.models.Passenger;
import core.models.Plane;
import core.models.jsonReader.ReadJsonFlight;
import core.models.jsonReader.ReadJsonLocation;
import core.models.jsonReader.ReadJsonPassenger;
import core.models.jsonReader.ReadJsonPlane;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

/**
 *
 * @author Laura
 */
public class AddJsonToStorage {

    public static Response addJson() {
        try {
            ReadJsonLocation jsonLocation = new ReadJsonLocation();
            ArrayList<Location> locations = jsonLocation.read("src\\json\\locations.json");

            ReadJsonFlight jsonFlights = new ReadJsonFlight();
            ArrayList<Flight> flights = jsonFlights.read("src\\json\\flights.json");

            ReadJsonPassenger jsonPassenger = new ReadJsonPassenger();
            ArrayList<Passenger> passengers = jsonPassenger.read("src\\json\\passengers.json");

            ReadJsonPlane jsonPlanes = new ReadJsonPlane();
            ArrayList<Plane> planes = jsonPlanes.read("src\\json\\planes.json");

            return new Response("File upload successfully", Status.OK);
        } catch (IOException | JSONException e) {
            return new Response("Problems with reading files", Status.INTERNAL_SERVER_ERROR);
        }catch(Exception e){
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }

    }
}
