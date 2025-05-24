package core.models.jsonReader;

import core.models.Passenger;
import core.models.storage.PassengerStorage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.JSONException;

public class ReadJsonPassenger implements JsonReader<Passenger> {

    @Override
    public ArrayList<Passenger> read(String path) throws IOException, JSONException {
        ArrayList<Passenger> passengers = new ArrayList<>();

        InputStream is = new FileInputStream(path);
        JSONArray array = new JSONArray(new JSONTokener(is));

        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            String birthStr = obj.getString("birthDate");
            LocalDate birthDate = LocalDate.parse(birthStr);
            Passenger p = new Passenger(
                    obj.getInt("id"),
                    obj.getString("firstname"),
                    obj.getString("lastname"),
                    birthDate,
                    obj.getInt("countryPhoneCode"),
                    obj.getInt("phone"),
                    obj.getString("country")
            );
            passengers.add(p);
        }
        PassengerStorage passengerRegister = PassengerStorage.getInstance();
        passengerRegister.setPassengers(passengers);
        return passengers;
    }
}
