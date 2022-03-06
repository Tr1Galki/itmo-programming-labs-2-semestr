package mainLogic;

import data.Coordinates;
import data.FuelType;
import data.VehicleType;

public interface IAskManager {
    String askName();
    Coordinates askCoordinates();
    long askCoordinateX();
    Double askCoordinateY();
    Integer askEnginePower();
    VehicleType askType();
    FuelType askFuelType();
}
