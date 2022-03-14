package mainLogic;

import Exceptions.ExecuteScriptRecursiveException;
import data.FuelType;
import data.Vehicle;
import file.OutputManager;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CollectionManager implements ICollectionManagerUnchanged, ICollectionManagerChanged{
    private static final AtomicInteger currID = new AtomicInteger();
    private final HashSet<Vehicle> vehicleCollection = new HashSet<>();
    private final HashMap<String, String> commandList = new HashMap<>();
    private final java.util.Date creationDate = new Date();

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
        System.out.println("- Type of collection: HashSet of Vehicle classes");
        System.out.println("- Date of initializing: " + creationDate);
        System.out.println("- Count of elements: " + vehicleCollection.size());
        System.out.println("- Author: " + "Aleksandr \"Alever\" Gasyuk");
    }

    @Override
    public void show() {
        List<Vehicle> sortCollection = new ArrayList<>( vehicleCollection);
        sortCollection.sort(Comparator.comparing(Vehicle::getId));

        if (vehicleCollection.size() == 0){
            System.out.println("Collection is empty");
            return;
        }

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

        System.out.println("Number of vehicles which enginePower is " + enginePower +" - " + countOfPower);
    }

    @Override
    public void printDescending() {
        List<Vehicle> sortCollection = new ArrayList<>(vehicleCollection);
        sortCollection.sort(Comparator.comparing(Vehicle::getId));

        if (vehicleCollection.size() == 0){
            System.out.println("Collection is empty");
            return;
        }

        for(int i = sortCollection.size() - 1; i >= 0; i--) {
            System.out.print(sortCollection.get(i));
        }

    }

    @Override
    public void add() {
        Vehicle tempVehicle = new Vehicle(getId(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
        vehicleCollection.add(tempVehicle);
        System.out.println("element added✓");
    }

    @Override
    public void updateID(int id) {
        boolean isId = false;

        for (Vehicle item: vehicleCollection) {
            if (item.getId() == id) {
                isId = true;
                break;
            }
        }

        if (isId){
            vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getId() == id));
            Vehicle tempVehicle = new Vehicle(id, askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());
            vehicleCollection.add(tempVehicle);
            System.out.println("element ID updated✓");
            return;
        }

        System.out.println("There is no one element with this id");
    }

    @Override
    public void removeByID(int id) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getId() == id));
        System.out.println("remove ended✓");
    }

    @Override
    public void clear() {
        vehicleCollection.clear();
        System.out.println("Clearing ended✓");
    }

    @Override
    public void addIfMax() {
        long maxId = 0;
        for (Vehicle thisVehicle : vehicleCollection){
            if (thisVehicle.getCoordinateX() > maxId){
                maxId = thisVehicle.getCoordinateX();
            }
        }

        Vehicle tempVehicle = new Vehicle(getId(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());

        if (tempVehicle.getCoordinateX() > maxId){
            add();
            System.out.println("Element added✓");
        }
        else {
            System.out.println("This element is not max, sorry");
        }
    }

    @Override
    public void removeGreater() {
        Vehicle tempVehicle = new Vehicle(getId(), askManager.askName(), askManager.askCoordinates(), askManager.askEnginePower(), askManager.askType(), askManager.askFuelType());

        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getCoordinateX() > tempVehicle.getCoordinateX()));
        System.out.println("Remove ended✓");
    }

    @Override
    public void removeAllByFuelType(FuelType fuelType) {
        vehicleCollection.removeIf(thisVehicle -> (thisVehicle.getFuelType().equals(fuelType)));
        System.out.println("Remove ended✓");
    }

    @Override
    public void save() {
        OutputManager outputManager = new OutputManager();
        try {
            outputManager.saveCollection(vehicleCollection);
        }
        catch (IOException e) {
            System.out.println("CAN NOT SAVE! ALARMED! You can try later :)");
        }
    }

    @Override
    public void executeScript(String fileName) {
        LinkedList<String> fileNamesList = new LinkedList<>();
        fileNamesList.addFirst(fileName);
        String command;
        try {
            System.out.println("Reading from "+ fileName + " started");
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            command = inputStreamReader.readLine();

            while (command != null) {
                List<String> wordList = new ArrayList<>(Arrays.asList(command.split(" ")));
                wordList.removeAll(Arrays.asList("", null));
                System.out.println("Сейчас идёт обработка команды "+ wordList.get(0));
                switch (wordList.size()) {
                    case 1: {
                        if (wordList.get(0).equals("help")) {
                            help();
                            break;
                        }
                        if (wordList.get(0).equals("info")) {
                            info();
                            break;
                        }
                        if (wordList.get(0).equals("show")) {
                            show();
                            break;
                        }
                        if (wordList.get(0).equals("add")) {
                            add();
                            break;
                        }
                        if (wordList.get(0).equals("clear")) {
                            clear();
                            break;
                        }
                        if (wordList.get(0).equals("save")) {
                            save();
                            break;
                        }
                        if (wordList.get(0).equals("exit")) {

                            return;
                        }
                        if (wordList.get(0).equals("add_if_max")) {
                            addIfMax();
                            break;
                        }
                        if (wordList.get(0).equals("remove_greater")) {
                            removeGreater();
                            break;
                        }
                        if (wordList.get(0).equals("print_descending")) {
                            printDescending();
                            break;
                        }
                    }
                    case 2: {
                        if (wordList.get(0).equals("update")) {
                            updateID(Integer.parseInt(wordList.get(1)));
                            break;
                        }
                        if (wordList.get(0).equals("remove_by_id")) {
                            removeByID(Integer.parseInt(wordList.get(1)));
                            break;
                        }
                        if (wordList.get(0).equals("execute_script")) {
                            if (fileNamesList.contains(wordList.get(1))) throw new ExecuteScriptRecursiveException();
                            fileNamesList.addFirst(wordList.get(1));
                            executeScript(wordList.get(1));
                            break;
                        }
                        if (wordList.get(0).equals("remove_all_by_fuel_type") ) {
                            removeAllByFuelType(FuelType.valueOf(wordList.get(1).toUpperCase()));
                            break;
                        }
                        if (wordList.get(0).equals("count_by_engine_power")) {
                            countByEnginePower(Integer.parseInt(wordList.get(1)));
                            break;
                        }
                    }
                    System.out.println("Command " + wordList.get(1) + " is wrong");
                }
                command = inputStreamReader.readLine();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File doesn't exist");
        }
        catch(IOException ex){
            System.out.println("There is some troubles with site, try later :(");
        }
        catch(ExecuteScriptRecursiveException exc){
            System.out.println(exc.getMessage());
        }

    }
}