package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import data.Vehicle;

/**
 * The manager of all file work like reading and writing.
 *
 * @author Alever
 */
public class FileManager implements IFileManager{

    @Override
    public void saveCollection(HashSet<Vehicle> collection) throws IOException {
        Gson json = new GsonBuilder().setPrettyPrinting().create();
        String gson = json.toJson(collection);
        FileOutputStream save = new FileOutputStream("output_collection.json");
        save.write(gson.getBytes());
    }

    /**
     * Fill HashSet collection of Vehicle from json file.
     *
     * @see Vehicle
     * @see mainLogic.CollectionManager
     * @return the HashSet of main collection
     * @throws IOException the io exception-_-
     */
    static public HashSet<Vehicle> fillCollectionByFile() throws IOException {
        Gson gson = new Gson();
        Type entityType = new TypeToken<HashSet<Vehicle>>(){}.getType();
        FileReader read = new FileReader("ПЕРЕМЕННАЯ ОКРУЖЕНИЯ");
        return gson.fromJson(read , entityType); 
    }
}