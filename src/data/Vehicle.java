package data;

import java.util.Date;

public class Vehicle implements Comparable<Vehicle>{
    static private int currID = 1;

    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null
    private FuelType fuelType; //Поле может быть null

    public Vehicle() {
        this.id = currID++;
        this.name = "1";
        this.coordinates = new Coordinates(1, 1.0);
        this.creationDate = new Date();
        this.enginePower = 1;
        this.type = VehicleType.CAR;
        this.fuelType = FuelType.ELECTRICITY;
    }

    public int getIdPlus(){
        int predID = currID++;
        return predID;
    }

    public Integer getEnginePower(){
        return enginePower;
    }

    public static int getCurrID() {
        return currID;
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


    public static void setCurrID(int currID) {
        Vehicle.currID = currID;
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
                "; coordinates = " + coordinates +
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
