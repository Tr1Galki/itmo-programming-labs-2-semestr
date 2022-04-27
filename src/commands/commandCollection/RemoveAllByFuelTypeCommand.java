package commands.commandCollection;

import commands.Command;
import data.vehiclec.FuelType;
import data.vehiclec.Vehicle;
import server.dataBase.DatabaseManager;

import java.util.HashSet;

public class RemoveAllByFuelTypeCommand extends Command {

    @Override
    public void userExecute() {
        setName("remove_all_by_fuel_type");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        DatabaseManager.removeVehicleByFuel(getArg().toUpperCase());
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getFuelType().equals(FuelType.valueOf(getArg().toUpperCase())))
                && (thisVehicle.getOwnerName().equals(getLogin())));
        return("Remove ended✓");
    }
}