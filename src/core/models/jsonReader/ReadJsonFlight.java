package core.models.jsonReader;

import core.models.Flight;
import core.models.Location;
import core.models.storage.PlaneStorage;
import core.models.Plane;
import core.models.storage.FlightStorage;
import core.models.storage.LocationStorage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.json.JSONException;

public class ReadJsonFlight implements JsonReader<Flight> {

    @Override
    public ArrayList<Flight> read(String path) throws IOException, JSONException {
        ArrayList<Flight> flights = new ArrayList<>();

        InputStream is = new FileInputStream(path);
        JSONArray array = new JSONArray(new JSONTokener(is));

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String id = obj.getString("id");
            String planeId = obj.getString("plane");
            String departureLocationId = obj.getString("departureLocation");
            String arrivalLocationId = obj.getString("arrivalLocation");
            String scaleLocationId = obj.optString("scaleLocation", null);
            String departureStr = obj.getString("departureDate");
            LocalDateTime departureDate = LocalDateTime.parse(departureStr); // como el constructor está en LocalDate, toca volver a parsear
            int hoursArrival = obj.getInt("hoursDurationArrival");
            int minutesArrival = obj.getInt("minutesDurationArrival");
            int hoursScale = obj.getInt("hoursDurationScale");
            int minutesScale = obj.getInt("minutesDurationScale");
            Plane plane = null;
            Location departureLocation = null;
            Location arrivalLocation = null;
            Location scaleLocation = null;

            PlaneStorage storageP = PlaneStorage.getInstance();
            LocationStorage storageL = LocationStorage.getInstance();
            for (Plane p : storageP.getPlanes()) {
                if (p.getId().equals(planeId)) {
                    plane = p;
                }
            }
            for (Location l : storageL.getLocations()) {
                if (l.getAirportId().equals(departureLocationId)) {
                    departureLocation = l;
                }
            }
            for (Location l : storageL.getLocations()) {
                if (l.getAirportId().equals(arrivalLocationId)) {
                    arrivalLocation = l;
                }
            }
            for (Location l : storageL.getLocations()) {
                if (l.getAirportId().equals(scaleLocationId)) {
                    scaleLocation = l;
                }
            }
            Flight flight = new Flight(id, plane,
                    departureLocation,
                    arrivalLocation,
                    scaleLocation,
                    departureDate,
                    hoursArrival,
                    minutesArrival,
                    hoursScale,
                    minutesScale);

            flights.add(flight);
        }

        FlightStorage flightRegister = FlightStorage.getInstance();
        flightRegister.setFlights(flights);
        return flights;
    }
}
