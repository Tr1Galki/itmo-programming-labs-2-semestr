package commands.commandCollection;

import client.UserManager;
import client.askTools.AskManager;
import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class RemoveGreaterCommand extends Command {


    @Override
    public void userExecute() {
        setName("remove_greater");
        final AskManager askManager = new AskManager();
        Vehicle vehicle = new Vehicle(UserManager.login, getIntArg(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        setVehicle(vehicle);
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getCoordinateX() > getVehicle().getCoordinateX())&&
                (thisVehicle.getOwnerName().equals(getLogin())));
        return("Remove ended✓");
    }
}
