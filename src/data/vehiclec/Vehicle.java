package data.vehiclec;

import java.io.Serializable;
import java.util.Date;

/**
 * The type Vehicle.
 * client.Main element.
 *
 * @author Alever
 */
public class Vehicle implements Comparable<Vehicle>, Serializable {
    private String ownerName;
    /**
     * The id.
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * The Name.
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * The Coordinates.
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * The Creation date.
     */
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * The Engine power.
     */
    private Integer enginePower; //Поле может быть null, Значение поля должно быть больше 0
    /**
     * The Type.
     */
    private VehicleType type; //Поле может быть null
    /**
     * The Fuel type.
     */
    private FuelType fuelType; //Поле может быть null


    /**
     * Instantiates a new Vehicle.
     *
     * @param id          the id
     * @param name        the name
     * @param coordinates the coordinates
     * @param enginePower the engine power
     * @param type        the type
     * @param fuelType    the fuel type
     */
    public Vehicle(int id, String name, Coordinates coordinates, Integer enginePower, VehicleType type, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.enginePower = enginePower;
        this.type = type;
        this.fuelType = fuelType;
    }

    /**
     * Get engine power integer.
     *
     * @return the integer
     */
    public Integer getEnginePower(){
        return enginePower;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
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
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Gets coordinate x.
     *
     * @return the coordinate x
     */
    public long getCoordinateX() {
        return coordinates.getX();
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
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
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets engine power.
     *
     * @param enginePower the engine power
     */
    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Sets VehicleType.
     *
     * @param type the type
     */
    public void setType(VehicleType type) {
        this.type = type;
    }

    /**
     * Sets FuelType.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return  "Vehicle{" +
                "id = " + id +
                "; name = " + name + '\'' +
                "; coordinates X = " + coordinates.getX() +
                "; coordinates Y = " + coordinates.getY() +
                "; creationDate = " + creationDate +
                "; enginePower = " + enginePower +
                "; type = " + type +
                "; fuelType = " + fuelType +
                "}" + "\n";
    }

    @Override
    public int compareTo(Vehicle v) {
        return id - v.id;
    }
}
