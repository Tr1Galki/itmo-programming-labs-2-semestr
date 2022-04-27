package server;

import commands.Command;
import data.vehiclec.Vehicle;
import file.FileManager;
import server.dataBase.DatabaseManager;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * The type Server collection.
 */
public class ServerCollection {

    /**
     * The History collection.
     */
    private final LinkedList<String> historyCollection = new LinkedList<>();

    /**
     * The Curr id.
     */
    private int currID;

    /**
     * The Vehicle collection.
     */
    private final HashSet<Vehicle> vehicleCollection;

    /**
     * The Creation date.
     */
    private final java.util.Date creationDate = new Date();

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * The File manager.
     */
    private final FileManager fileManager = new FileManager();

    /**
     * Gets id.
     *
     * @return the id
     */
    private int getId() {
        int maxId = 0;
        for (Vehicle item : vehicleCollection) {
            if (item.getId() > maxId) {
                maxId = item.getId();
            }
        }

        while (currID <= maxId) {
            currID++;
        }

        return (currID);
    }

    /**
     * Instantiates a new Server collection.
     */
    public ServerCollection() {
        HashSet<Vehicle> tempVehicleCollection;
        try {
            tempVehicleCollection = FileManager.fillCollectionByFile();
        } catch (IOException e){
            tempVehicleCollection = new HashSet<Vehicle>();
        }
        vehicleCollection = tempVehicleCollection;
        DatabaseManager.clearDatabase();
        for (Vehicle vehicle: vehicleCollection){
            DatabaseManager.addVehicleToDatabase(vehicle);
        }
    }

    /**
     * Execute command string.
     *
     * @param thisCommand the this command
     * @return the string
     */
    public String executeCommand(Command thisCommand){
        FileManager.log.info("Trying to execute " + thisCommand.getName() + " command");
        historyCollection.add(thisCommand.getName());
        if (thisCommand.getName().equals("history")){
            thisCommand.setHistoryCollection(this.historyCollection);
        }
        thisCommand.setIntArg(this.getId());
        if (thisCommand.getName().equals("info")) {
            thisCommand.setDateArg(this.getCreationDate());
        }
        if (thisCommand.getName().equals("add")) {
            DatabaseManager.clearDatabase();
            for (Vehicle vehicle: vehicleCollection){
                DatabaseManager.addVehicleToDatabase(vehicle);
            }
        }
        return (thisCommand.serverExecute(vehicleCollection));
    }

    /**
     * Save.
     *
     * @throws IOException the io exception
     */
    public void save() throws IOException {
        fileManager.saveCollection(vehicleCollection);
    }

}
