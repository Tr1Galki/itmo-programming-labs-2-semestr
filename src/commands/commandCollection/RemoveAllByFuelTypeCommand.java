package commands.commandCollection;

import commands.Command;
import data.vehiclec.FuelType;
import data.vehiclec.Vehicle;

import java.util.HashSet;

public class RemoveAllByFuelTypeCommand extends Command {

    @Override
    public void userExecute() {
        setName("remove_all_by_fuel_type");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getFuelType().equals(FuelType.valueOf(getArg().toUpperCase()))));
        return("Remove ended✓");
    }
}
