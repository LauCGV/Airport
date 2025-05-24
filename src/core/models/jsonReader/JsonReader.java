package core.models.jsonReader;

import java.util.ArrayList;

public interface JsonReader<T> {
   public ArrayList<T> read(String path);
}

