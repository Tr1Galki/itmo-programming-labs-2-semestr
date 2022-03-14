package mainLogic;

import data.FuelType;

public interface ICollectionManagerChanged {
    void add();
    void updateID(int id);
    void removeByID(int id);
    void clear();
    void addIfMax();
    void removeGreater();
    void removeAllByFuelType(FuelType fuelType);
}
