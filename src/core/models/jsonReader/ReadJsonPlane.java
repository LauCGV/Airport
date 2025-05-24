package core.models.jsonReader;

import core.models.Plane;
import core.models.storage.PlaneStorage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;

public class ReadJsonPlane implements JsonReader<Plane> {

    @Override
    public ArrayList<Plane> read(String path) throws IOException, JSONException {
        ArrayList<Plane> planes = new ArrayList<>();

        InputStream is = new FileInputStream(path);
        JSONArray array = new JSONArray(new JSONTokener(is));

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            Plane plane = new Plane(
                    obj.getString("id"),
                    obj.getString("brand"),
                    obj.getString("model"),
                    obj.getInt("maxCapacity"),
                    obj.getString("airline")
            );
            PlaneStorage planeRegister = PlaneStorage.getInstance();
            planeRegister.setPlanes(planes);
            planes.add(plane);
        }

        return planes;
    }
}
