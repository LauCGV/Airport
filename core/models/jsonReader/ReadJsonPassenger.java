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
            JSONObject object = array.getJSONObject(i);

            String birthDateString = object.getString("birthDate");
            LocalDate birthDate = LocalDate.parse(birthDateString);
            Passenger passenger = new Passenger(
                    object.getInt("id"),
                    object.getString("firstname"),
                    object.getString("lastname"),
                    birthDate,
                    object.getInt("countryPhoneCode"),
                    object.getInt("phone"),
                    object.getString("country")
            );
            passengers.add(passenger);
        }
        PassengerStorage passengerRegister = PassengerStorage.getInstance();
        passengerRegister.setPassengers(passengers);
        return passengers;
    }
}
