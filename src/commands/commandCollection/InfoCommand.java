package commands.commandCollection;

import commands.Command;
import data.Vehicle;

import java.util.HashSet;

public class InfoCommand extends Command {

    @Override
    public void userExecute() {
        setName("info");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        StringBuilder retString = new StringBuilder();

        retString.append("Collection information:");
        retString.append("\n").append("- Type of collection: HashSet of Vehicle classes");
        retString.append("\n").append("- Date of initializing: ").append(getDateArg().toString());
        retString.append("\n").append("- Count of elements: ").append(vehicleCollection.size());
        retString.append("\n").append("- Author: " + "Aleksandr \"Alever\" Gasyuk");

        return retString.toString();
    }
}
