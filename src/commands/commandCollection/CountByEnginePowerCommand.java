package commands.commandCollection;

import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;
import java.util.Objects;

public class CountByEnginePowerCommand extends Command {

    @Override
    public void userExecute() {
        setName("count_by_engine_power");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        int countOfPower = 0;

        for (Vehicle vehicle : vehicleCollection) {
            if (Objects.equals(vehicle.getEnginePower(), Integer.parseInt(getArg()))) {
                countOfPower++;
            }
        }

        return ("Number of vehicles which enginePower is " + getArg() + " - " + countOfPower);
    }
}
