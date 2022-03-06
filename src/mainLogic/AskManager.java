package mainLogic;

import data.Coordinates;
import data.FuelType;
import data.VehicleType;
import java.util.Scanner;
import java.util.Date;

public class AskManager implements IAskManager{
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askName() {
        String name;
        System.out.print("Enter title: ");
        name = scanner.nextLine().trim();
        return name;
    }

    @Override
    public Coordinates askCoordinates() {
        Coordinates coordinates;
        System.out.println("Enter coordinates: ");
        coordinates = new Coordinates(askCoordinateX(),askCoordinateY());
        return coordinates;
    }

    @Override
    public long askCoordinateX() {
        String strX;
        long x;
        System.out.print("x = ");
        strX = scanner.nextLine().trim();
        x = Long.parseLong(strX);
        return x;
    }

    @Override
    public Double askCoordinateY() {
        String strY;
        Double y;
        System.out.print("y = ");
        strY = scanner.nextLine().trim();
        y = Double.parseDouble(strY);
        return y;
    }

    @Override
    public Integer askEnginePower() {
        String strEnginePower;
        Integer enginePower;
        System.out.print("Enter engine power: ");
        strEnginePower = scanner.nextLine().trim();
        enginePower = Integer.parseInt(strEnginePower);
        return enginePower;
    }

    @Override
    public VehicleType askType() {
        String strType;
        VehicleType vehicleType;
        System.out.print("Choose your vehicle type {car, plane, drone, ship, chopper}: ");
        strType = scanner.nextLine().trim();
        String str = strType.toUpperCase();
        vehicleType = VehicleType.valueOf(str);
        return vehicleType;
    }

    @Override
    public FuelType askFuelType() {
        String strType;
        FuelType fuelType;
        System.out.print("Choose your fuel type {gasoline, kerosene, electricity, manpower, antimatter}: ");
        strType = scanner.nextLine().trim();
        String str = strType.toUpperCase();
        fuelType = FuelType.valueOf(str);
        return fuelType;
    }
}
