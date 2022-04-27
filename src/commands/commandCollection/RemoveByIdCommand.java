package commands.commandCollection;

import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class RemoveByIdCommand extends Command {

    @Override
    public void userExecute() {
        setName("remove_by_id");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        boolean isId = false;
        int id = Integer.parseInt(getArg());

        for (Vehicle item : vehicleCollection) {
            if (item.getId() == id) {
                isId = true;
                break;
            }
        }
        if (isId) {
            vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getId() == id) &&
                    (thisVehicle.getOwnerName().equals(getLogin())));
            return("remove ended✓");
        } else {
            return("element with this id doesn't exist or this is not your file");
        }
    }
}
