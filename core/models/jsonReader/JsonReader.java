package core.models.jsonReader;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;

public interface JsonReader<T> {
   public ArrayList<T> read(String path) throws IOException, JSONException;
}

