package data;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle>{

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null
    private FuelType fuelType; //Поле может быть null


    public Vehicle(int id, String name, Coordinates coordinates, Integer enginePower, VehicleType type, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.enginePower = enginePower;
        this.type = type;
        this.fuelType = fuelType;
    }

    public Integer getEnginePower(){
        return enginePower;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public VehicleType getType() {
        return type;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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
