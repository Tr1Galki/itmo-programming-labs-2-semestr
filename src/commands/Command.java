package commands;

import data.Vehicle;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * The type Command.
 */
public abstract class Command implements Serializable {

    /**
     * The Name.
     */
    private String name = "";

    /**
     * The Vehicle.
     */
    private Vehicle vehicle;

    /**
     * The Arg.
     */
    private String arg = "";

    /**
     * The Int arg.
     */
    private int intArg = 0;

    /**
     * The Date arg.
     */
    private Date dateArg;

    /**
     * The History collection.
     */
    private LinkedList<String> historyCollection = new LinkedList<>();

    /**
     * User execute.
     */
    public void userExecute(){};

    /**
     * Server execute string.
     *
     * @param vehicleCollection the vehicle collection
     * @return the string
     */
    public String serverExecute(HashSet<Vehicle> vehicleCollection){
        return "";
    }

    /**
     * Gets arg.
     *
     * @return the arg
     */
    public String getArg() {
        return arg;
    }

    /**
     * Sets arg.
     *
     * @param arg the arg
     */
    public void setArg(String arg) {
        this.arg = arg;
    }

    /**
     * Gets int arg.
     *
     * @return the int arg
     */
    public int getIntArg() {
        return intArg;
    }

    /**
     * Sets int arg.
     *
     * @param intArg the int arg
     */
    public void setIntArg(int intArg) {
        this.intArg = intArg;
    }

    /**
     * Gets date arg.
     *
     * @return the date arg
     */
    public Date getDateArg() {
        return dateArg;
    }

    /**
     * Sets date arg.
     *
     * @param dateArg the date arg
     */
    public void setDateArg(Date dateArg) {
        this.dateArg = dateArg;
    }

    /**
     * Gets vehicle.
     *
     * @return the vehicle
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * Sets vehicle.
     *
     * @param vehicle the vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets history collection.
     *
     * @return the history collection
     */
    public LinkedList<String> getHistoryCollection() {
        return historyCollection;
    }

    /**
     * Sets history collection.
     *
     * @param historyCollection the history collection
     */
    public void setHistoryCollection(LinkedList<String> historyCollection) {
        this.historyCollection = historyCollection;
    }
}