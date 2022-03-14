package mainLogic;

import Exceptions.IncorrectValueException;
import Exceptions.NotEmptyException;
import data.Coordinates;
import data.FuelType;
import data.VehicleType;
import java.util.Scanner;

/**
 * The type Ask manager.
 */
public class AskManager implements IAskManager{
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String askName() {
        String name;
        try {
            System.out.print("Enter title: ");
            name = scanner.nextLine().trim();
            if (name.equals("")) throw new NotEmptyException();
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askName();
        }
        catch (NullPointerException e){
            System.out.println("Name can not be Null");
            return askName();
        }
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
        try {
            System.out.print("x = ");
            strX = scanner.nextLine().trim();
            if (strX.equals("")) throw new NotEmptyException();
            if (Long.parseLong(strX) <= -893) throw new IncorrectValueException();
            x = Long.parseLong(strX);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateX();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateX();
        }
        return x;
    }

    @Override
    public Double askCoordinateY() {
        String strY;
        Double y;
        try {
            System.out.print("y = ");
            strY = scanner.nextLine().trim();
            if (strY.equals("")) throw new NotEmptyException();
            if (Double.parseDouble(strY) <= -308) throw new IncorrectValueException();
            y = Double.parseDouble(strY);
        }
        catch (NotEmptyException | IncorrectValueException e){
            System.out.println(e.getMessage());
            return askCoordinateY();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askCoordinateY();
        }
        catch (NullPointerException e){
            System.out.println("Coordinate can not be Null");
            return askCoordinateY();
        }
        return y;
    }

    @Override
    public Integer askEnginePower() {
        String strEnginePower;
        Integer enginePower;
        try {
            System.out.print("Enter engine power: ");
            strEnginePower = scanner.nextLine().trim();
            if (strEnginePower.equals("")) throw new NotEmptyException();
            if (Integer.parseInt(strEnginePower) <= 0) throw new IncorrectValueException();
            enginePower = Integer.parseInt(strEnginePower);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askEnginePower();
        }
        catch (NumberFormatException e){
            System.out.println("Incorrect value format");
            return askEnginePower();
        }
        catch (IncorrectValueException e){
            System.out.println("Value must be more than zero");
            return askEnginePower();
        }
        return enginePower;
    }


    @Override
    public VehicleType askType() {
        String strType;
        VehicleType vehicleType;
        try {
            System.out.print("Choose your vehicle type {car, plane, drone, ship, chopper}: ");
            strType = scanner.nextLine().trim();
            String extraString = strType.toUpperCase();
            if (strType.equals("")) throw new NotEmptyException();
            vehicleType = VehicleType.valueOf(extraString);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askType();
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
            return askType();
        }
        return vehicleType;
    }

    @Override
    public FuelType askFuelType() {
        String strType;
        FuelType fuelType;
        try {
            System.out.print("Choose your fuel type {gasoline, kerosene, electricity, manpower, antimatter}: ");
            strType = scanner.nextLine().trim();
            String extraString = strType.toUpperCase();
            if (extraString.equals("")) throw new NotEmptyException();
            fuelType = FuelType.valueOf(extraString);
        }
        catch (NotEmptyException e){
            System.out.println(e.getMessage());
            return askFuelType();
        }
        catch (IllegalArgumentException ex) {
            System.out.println("This value is incorrect");
            return askFuelType();
        }
        return fuelType;
    }
}
