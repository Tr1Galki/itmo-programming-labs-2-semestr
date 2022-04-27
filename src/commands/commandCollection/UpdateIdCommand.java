package commands.commandCollection;

import client.UserManager;
import client.askTools.AskManager;
import commands.Command;
import data.vehiclec.Vehicle;
import server.dataBase.DatabaseManager;

import java.util.HashSet;

public class UpdateIdCommand extends Command {

    @Override
    public void userExecute() {
        setName("update_id");
        final AskManager askManager = new AskManager();
        Vehicle vehicle = new Vehicle(UserManager.login, getIntArg(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        setVehicle(vehicle);
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        boolean isId = false;

        for (Vehicle item : vehicleCollection) {
            if (item.getId() == Integer.parseInt(getArg())) {
                isId = true;
                break;
            }
        }

        if (isId) {
            vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getId() == Integer.parseInt(getArg())) &&
                    (thisVehicle.getOwnerName().equals(getLogin())));
            DatabaseManager.addVehicleToDatabase(getVehicle());
            vehicleCollection.add(getVehicle());
            return ("element ID updated✓");
        }

        return ("There is no one element with this id");
    }
}
