package commands.commandCollection;

import client.UserManager;
import client.askTools.AskManager;
import commands.Command;
import data.vehiclec.Vehicle;
import server.dataBase.DatabaseManager;

import java.util.HashSet;

public class AddCommand extends Command {

    @Override
    public void userExecute() {
        setName("add");
        final AskManager askManager = new AskManager();
        Vehicle vehicle = new Vehicle(UserManager.login, getIntArg(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        setVehicle(vehicle);
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        Vehicle tempVehicle = getVehicle();
        tempVehicle.setId(getIntArg());
        setVehicle(tempVehicle);
        DatabaseManager.addVehicleToDatabase(getVehicle());
        vehicleCollection.add(getVehicle());
        return("element added✓");
    }
}
