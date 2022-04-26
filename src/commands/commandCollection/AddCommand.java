package commands.commandCollection;

import client.askTools.AskManager;
import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class AddCommand extends Command {

    @Override
    public void userExecute() {
        setName("add");
        final AskManager askManager = new AskManager();
        Vehicle vehicle = new Vehicle(getIntArg(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        setVehicle(vehicle);
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        Vehicle tempVehicle = getVehicle();
        tempVehicle.setId(getIntArg());
        setVehicle(tempVehicle);
        vehicleCollection.add(getVehicle());
        return("element added✓");
    }
}
