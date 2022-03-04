package mainLogic;

import data.FuelType;
import data.Vehicle;

public interface ICollectionManagerChanged {
    void add(Vehicle element);
    void updateID(int id, Vehicle element);
    void removeByID(int id);
    void clear();
    void addIfMax(Vehicle element);
    void removeGreater(Integer enginePower);
    void removeAllByFuelType(FuelType fuelType);
}
