package file;

import data.Vehicle;

import java.io.IOException;
import java.util.HashSet;

/**
 * The interface of FileManager.
 *
 * @author Alever
 */
public interface IFileManager {
    /**
     * Save collection to the file.
     *
     * @param collection HashSet of the main collection
     * @throws IOException the io exception
     */
    void saveCollection(HashSet<Vehicle> collection) throws IOException;
}
