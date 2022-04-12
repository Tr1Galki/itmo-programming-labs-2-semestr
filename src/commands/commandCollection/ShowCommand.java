package commands.commandCollection;

import commands.Command;
import data.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ShowCommand extends Command {

    @Override
    public void userExecute() {
        setName("show");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        StringBuilder retString = new StringBuilder();
        List<Vehicle> sortCollection = new ArrayList<>(vehicleCollection);
        sortCollection.sort(Comparator.comparing(Vehicle::getId));

        if (vehicleCollection.size() == 0) {
            return ("Collection is empty");
        }

        for (Vehicle item : sortCollection) {
            retString.append(item);
        }

        return retString.toString();
    }
}
