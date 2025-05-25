package core.models.jsonReader;

import core.models.Location;
import core.models.storage.LocationStorage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;

public class ReadJsonLocation implements JsonReader<Location> {

    @Override
    public ArrayList<Location> read(String path) throws IOException, JSONException {
        ArrayList<Location> locations = new ArrayList<>();
        InputStream is = new FileInputStream(path);
        JSONArray array = new JSONArray(new JSONTokener(is));

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);

            Location location = new Location(
                    object.getString("airportId"),
                    object.getString("airportName"),
                    object.getString("airportCity"),
                    object.getString("airportCountry"),
                    object.getDouble("airportLatitude"),
                    object.getDouble("airportLongitude")
            );

            locations.add(location);
        }
        LocationStorage locationRegister = LocationStorage.getInstance();
        locationRegister.setLocations(locations);
        return locations;
    }
}
