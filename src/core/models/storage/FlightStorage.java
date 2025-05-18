/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Laura
 */
public class FlightStorage implements Storage {
    
    

    @Override
    public void add(ArrayList<Object> objects) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get("flights.json")));
            
            //Convertir a JSONArray
            JSONArray flights = new JSONArray(contenido);
            
            //Recorrer para obtener cada objeto
            for(int i=0; i<flights.length();i++){
                JSONObject flight = flights.getJSONObject(i);
                String ID = flight.getString("id");
                String plane = flight.getString("plane");
                String departureLocation = flight.getString("departureLocation");
                String arrivalLocation = flight.getString("arrivalLocation");
                String scaleLocation = flight.getString("scaleLocation");
                LocalDateTime departureDate = LocalDateTime.parse(flight.getString("2025-06-01T14:30:00"));
                int hoursDurationArrival = flight.getInt("hoursDurationArrival");
                int minutesDurationArrival = flight.getInt("minutesDurationArrival");
                int hoursDurationScale = flight.getInt("hoursDurationScale");
                int minutesDurationScale = flight.getInt("minutesDurationScale");
                
                
        //String id, Plane plane, Location departureLocation, Location arrivalLocation, LocalDateTime departureDate, int hoursDurationArrival, int minutesDurationArrival
                if(scaleLocation != null){
                    ;
                }else{
                    
                }
                ;
                
            }
        } catch (IOException e)  {

        }
    }

}
