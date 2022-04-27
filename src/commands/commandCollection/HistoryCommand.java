package commands.commandCollection;

import commands.Command;
import data.vehiclec.Vehicle;

import java.util.HashSet;
import java.util.LinkedList;

public class HistoryCommand extends Command {
    @Override
    public void userExecute() {
        setName("history");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {

        StringBuilder retString = new StringBuilder();
        LinkedList<String> tempList = getHistoryCollection();

        for (String string : tempList){
            retString.append(" - ").append(string).append("\n");
        }

        return retString.toString();
    }
}
