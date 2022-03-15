package mainLogic;

/**
 * The interface of Collection manager with methods which not change the collection.
 *
 * @author Alever
 */
public interface ICollectionManagerUnchanged {
    /**
     * Show information about every command.
     */
    void help();

    /**
     * Show information about collection.
     */
    void info();

    /**
     * Print every element of collection.
     */
    void show();

    /**
     * Count of elements with this engine power.
     *
     * @param enginePower the enginePower Integer
     */
    void countByEnginePower(Integer enginePower);

    /**
     * Show inverse.
     */
    void printDescending();

    /**
     * Save collection to the file.
     */
    void save();

    /**
     * Run commands from this script.
     *
     * @param fileName String name of the file script
     */
    void executeScript(String fileName);
}
