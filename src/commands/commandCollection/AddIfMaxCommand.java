package commands.commandCollection;

import client.askTools.AskManager;
import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class AddIfMaxCommand extends Command {

    @Override
    public void userExecute() {
        setName("add_if_max");
        final AskManager askManager = new AskManager();
        Vehicle vehicle = new Vehicle(getIntArg(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        setVehicle(vehicle);
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        Vehicle tempVehicle = getVehicle();
        tempVehicle.setId(getIntArg());
        setVehicle(tempVehicle);

        long maxId = 0;
        for (Vehicle thisVehicle : vehicleCollection) {
            if (thisVehicle.getCoordinateX() > maxId) {
                maxId = thisVehicle.getCoordinateX();
            }
        }

        if (getVehicle().getCoordinateX() > maxId) {
            vehicleCollection.add(getVehicle());
            return("Element added✓");
        } else {
            return("This element is not max, sorry");
        }
    }
}
