package file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.util.logging.*;
import java.io.FileNotFoundException;
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

    /**
     * The constant for logging.
     */
    public static Logger log = Logger.getGlobal();

    /**
     * The constant env.
     */
    final static String env = System.getenv("LAB5");

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
     * @return the HashSet of main collection
     * @throws IOException            the io exception-_-
     * @throws FileNotFoundException  the file not found exception
     * @throws NoSuchElementException the no such element exception
     * @throws JsonParseException     the json parse exception
     * @see Vehicle
     * @see mainLogic.CollectionManager
     */
    static public HashSet<Vehicle> fillCollectionByFile() throws IOException, FileNotFoundException, NoSuchElementException, JsonParseException {
        try {
            Gson gson = new Gson();
            Type entityType = new TypeToken<HashSet<Vehicle>>() {
            }.getType();
            FileReader read = new FileReader("data.json");
            return gson.fromJson(read, entityType);
        }
        catch (FileNotFoundException e) {
            System.out.println("Input file does not exist");
        }
        catch (NoSuchElementException e){
            System.out.println("input file is empty");
        }
        catch (JsonParseException e){
            System.out.println("collection in file is illegal");
        }
        return new HashSet<Vehicle>();
    }
}