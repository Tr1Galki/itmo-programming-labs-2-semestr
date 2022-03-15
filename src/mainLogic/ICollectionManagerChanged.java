package mainLogic;

import data.FuelType;
import data.Vehicle;

/**
 * The interface of Collection manager with methods which changing main collection.
 *
 * @author Alever
 */
public interface ICollectionManagerChanged {
    /**
     * Add element to the collection
     * Use AskManager
     *
     * @see Vehicle
     * @see AskManager
     */
    void add();

    /**
     * Update element with id.
     *
     * @param id the id Integer
     */
    void updateID(int id);

    /**
     * Remove element by id.
     *
     * @param id the id Integer
     */
    void removeByID(int id);

    /**
     * Remove every element from collection.
     */
    void clear();

    /**
     * Add element if it is max.
     *
     * @see data.Vehicle
     * @see AskManager
     */
    void addIfMax();

    /**
     * Remove all element which greater than this.
     */
    void removeGreater();

    /**
     * Remove all elements with this FuelType.
     *
     * @see FuelType
     * @param fuelType the Enum FuelType
     */
    void removeAllByFuelType(FuelType fuelType);
}
