package mainLogic;

import data.FuelType;
import data.Vehicle;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionManager implements ICollectionManagerUnchanged, ICollectionManagerChanged{
    private static final AtomicInteger currID = new AtomicInteger();
    private final HashSet<Vehicle> vehicleCollection = new HashSet<>();
    private final HashMap<String, String> commandList = new HashMap<>();

    private final AskManager askManager = new AskManager();

    private int getId(){
        return currID.getAndIncrement();
    }

    @Override
    public void help() {
        if (commandList.size() == 0){
            commandList.put("help", "выводит справку по доступным командам");
            commandList.put("info", "выводит в стандартный поток вывода информацию о коллекции " +
                            "(тип, дата инициализации, количество элементов и т.д.)");
            commandList.put("show", "выводит в стандартный поток вывода все элементы коллекции в строковом " +
                            "представлении");
            commandList.put("add {element}", "добавляет новый элемент в коллекцию");
            commandList.put("update id {element}", "обновляет значение элемента коллекции, id которого равен заданному");
            commandList.put("remove_by_id id", "удаляет элемент из коллекции по его id");
            commandList.put("clear", "очищает коллекцию");
            commandList.put("save", "сохраняет коллекцию в файл");
            commandList.put("execute_script file_name", "считывает и исполняет скрипт из указанного файла. В скрипте " +
                            "содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном" +
                            " режиме.");
            commandList.put("exit", "завершает программу (без сохранения в файл)");
            commandList.put("add_if_max {element}", "добавляет новый элемент в коллекцию, если его значение превышает" +
                            " значение наибольшего элемента этой коллекции");
            commandList.put("remove_greater {element}", "удаляет из коллекции все элементы, превышающие заданный");
            commandList.put("history", "вывести последние 5 команд (без их аргументов)");
            commandList.put("remove_all_by_fuel_type fuelType", "удаляет из коллекции все элементы, значение поля " +
                            "fuelType которого эквивалентно заданному");
            commandList.put("count_by_engine_power enginePower", "выводит количество элементов, значение поля " +
                            "enginePower которых равно заданному");
            commandList.put("print_descending", "выводит элементы коллекции в порядке убывания");
        }

        System.out.println("All enable commands:");

        for(HashMap.Entry<String, String> item : commandList.entrySet()){
            System.out.print(item.getKey() + ": "+ item.getValue() + "\n");
        }
    }

    @Override
    public void info() {
        System.out.println("Collection information:");
        System.out.println("Type of collection - HashSet of Vehicle classes ");
        System.out.println("Date of initializing - NEED DORABOTKA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Count of elements - " + vehicleCollection.size());
        System.out.println("DO RA BOT KA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Override
    public void show() {
        List<Vehicle> sortCollection = new ArrayList<>( vehicleCollection);
        sortCollection.sort(Comparator.comparing(Vehicle::getId));

        for(Vehicle item : sortCollection){
            System.out.print(item);
        }
    }

    @Override
    public void countByEnginePower(Integer enginePower) {
        int countOfPower = 0;
        for (Vehicle vehicle: vehicleCollection){
            if (Objects.equals(vehicle.getEnginePower(), enginePower)){
                countOfPower++;
            }
        }

        System.out.println("Number of vehicles which have " + enginePower +" - " + countOfPower);
    }

    @Override
    public void printDescending() {
        /*List<Vehicle> sortCollection = new ArrayList<>( vehicleCollection);
        sortCollection.sort(Comparator.comparing(Vehicle::getId));

        for(Vehicle item : sortCollection){
            System.out.print(item);
        }
         */

    }

    @Override
    public void add() {
        Vehicle element = new Vehicle(getId(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        vehicleCollection.add(element);
    }

    @Override
    public void updateID(int id, Vehicle element) {
        for (Vehicle item: vehicleCollection) {
            if (item.getId() == id){
                item.setId(getId());
                return;
            }
        }

    }

    @Override
    public void removeByID(int id) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getId() == id));
    }

    @Override
    public void clear() {
        vehicleCollection.clear();
    }

    @Override
    public void addIfMax(Vehicle element) {
        int maxId = 0;
        for (Vehicle thisVehicle : vehicleCollection){
            if (thisVehicle.getId() > maxId){
                maxId = thisVehicle.getId();
            }
        }

        if (element.getId() > maxId){
            vehicleCollection.add(element);
        }
        else {
            //DROABOTKA
            System.out.println("DORABOTKA EXCEPTIONOV");
        }
    }

    @Override
    public void removeGreater(Integer enginePower) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getEnginePower() > enginePower));
        //NullPointerException!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    }

    @Override
    public void removeAllByFuelType(FuelType fuelType) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getFuelType().equals(fuelType)));//
        //NullPointerException!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }
}