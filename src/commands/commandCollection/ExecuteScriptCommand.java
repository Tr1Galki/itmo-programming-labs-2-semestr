package commands.commandCollection;

import commands.Command;
import data.Vehicle;

import java.util.HashSet;

public class ExecuteScriptCommand extends Command {

    @Override
    public void userExecute() {
        setName("execute_script");
    }

    @Override
    public String serverExecute(HashSet<Vehicle> vehicleCollection) {
        /*
        * LinkedList<String> fileNamesList = new LinkedList<>();
        fileNamesList.addFirst(fileName);
        String command;
        try {
            System.out.println("Reading from " + fileName + " started");
            BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            command = inputStreamReader.readLine();

            while (command != null) {
                List<String> wordList = new ArrayList<>(Arrays.asList(command.split(" ")));
                wordList.removeAll(Arrays.asList("", null));
                System.out.println("Сейчас идёт обработка команды " + wordList.get(0));
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
                        if (wordList.get(0).equals("remove_all_by_fuel_type")) {
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
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
        } catch (IOException ex) {
            System.out.println("There is some troubles with site, try later :(");
        } catch (ExecuteScriptRecursiveException exc) {
            System.out.println(exc.getMessage());
        }
        * */
        return "";
    }
}
