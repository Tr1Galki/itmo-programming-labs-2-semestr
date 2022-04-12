package client.askTools;

import data.Coordinates;
import data.FuelType;
import data.VehicleType;

/**
 * The interface of Ask manager.
 *
 * @author Alever
 */
public interface IAskManager {
    /**
     * Ask the String name field.
     *
     * @return the string
     */
    String askName();

    /**
     * Ask the coordinates (X and Y).
     *
     * @see Coordinates
     * @return Coordinates
     */
    Coordinates askCoordinates();

    /**
     * Ask coordinate X long.
     *
     * @return coordinate Y long
     */
    long askCoordinateX();

    /**
     * Ask coordinate Y double.
     *
     * @return coordinate Y double
     */
    Double askCoordinateY();

    /**
     * Ask the Integer enginePower field.
     *
     * @return enginePower Integer
     */
    Integer askEnginePower();

    /**
     * Ask VehicleType Enum field.
     *
     * @see VehicleType
     * @return the vehicle type.
     */
    VehicleType askType();

    /**
     * Ask FuelType Enum field.
     *
     * @see FuelType
     * @return the fuel type
     */
    FuelType askFuelType();
}
