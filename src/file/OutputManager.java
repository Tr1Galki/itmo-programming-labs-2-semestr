package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.Vehicle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class OutputManager {

    public void saveCollection(Collection collection) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String gson = json.toJson(collection);
        FileOutputStream save = new FileOutputStream("output_collection.json");
        save.write(gson.getBytes());
    }
}