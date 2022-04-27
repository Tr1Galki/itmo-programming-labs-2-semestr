package commands.commandCollection;

import commands.Command;
import data.vehiclec.FuelType;
import data.vehiclec.Vehicle;

import java.util.HashSet;

import static server.dataBase.DatabaseManager.clearDatabase;

public class ClearCommand extends Command {

    @Override
    public void userExecute() {
        setName("clear");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        clearDatabase();
        vehicleCollection.removeIf(thisVehicle -> thisVehicle.getOwnerName().equals(getLogin()));
        return ("Clearing ended✓");
    }
}
