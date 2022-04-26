package client;

import java.io.DataInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import commands.commandCollection.*;
import data.vehiclec.Vehicle;
import file.FileManager;


public class UserCommandManager {

    /**
     * The Input stream.
     */
    private DataInputStream inputStream;

    /**
     * The Object output stream.
     */
    private ObjectOutputStream objectOutputStream;

    public UserCommandManager(ObjectOutputStream objectOutputStream, DataInputStream inputStream){
        this.objectOutputStream = objectOutputStream;
        this.inputStream = inputStream;
    }

    public void startConsole(boolean exit) {
        FileManager.log.info("Start of execution");
        String input, command;
        Scanner scan = new Scanner(System.in);

        if (exit) {
            ClientToServerSender clientToServerSender = new ClientToServerSender(objectOutputStream, inputStream);
            ExitCommand exitCommand = new ExitCommand();
            exitCommand.userExecute();
            clientToServerSender.sendCommandToServer(exitCommand);
        } else {

            System.out.println("I know why you're here, User. I know what you've been doing...");

            ClientToServerSender clientToServerSender = new ClientToServerSender(objectOutputStream, inputStream);

            commandInput:
            while (true) {

                System.out.print("write command: ");
                input = scan.nextLine();

                List<String> wordList = new ArrayList<>(Arrays.asList(input.split(" ")));
                wordList.removeAll(Arrays.asList("", null));

                command = check(input);

                FileManager.log.info("Trying to execute " + command + " command");

                switch (command) {
                    case "wrong": {
                        System.out.println("Wrong command. Please repeat");
                        break;
                    }
                    case "help": {
                        HelpCommand helpCommand = new HelpCommand();
                        helpCommand.userExecute();
                        clientToServerSender.sendCommandToServer(helpCommand);
                        break;
                    }
                    case "info": {
                        InfoCommand infoCommand = new InfoCommand();
                        infoCommand.userExecute();
                        clientToServerSender.sendCommandToServer(infoCommand);
                        break;
                    }
                    case "show": {
                        ShowCommand showCommand = new ShowCommand();
                        showCommand.userExecute();
                        clientToServerSender.sendCommandToServer(showCommand);
                        break;
                    }
                    case "add": {
                        AddCommand addCommand = new AddCommand();
                        addCommand.userExecute();
                        clientToServerSender.sendCommandToServer(addCommand);
                        break;
                    }
                    case "clear": {
                        ClearCommand clearCommand = new ClearCommand();
                        clearCommand.userExecute();
                        clientToServerSender.sendCommandToServer(clearCommand);
                        break;
                    }
                    case "addIfMax": {
                        AddIfMaxCommand addIfMaxCommand = new AddIfMaxCommand();
                        addIfMaxCommand.userExecute();
                        clientToServerSender.sendCommandToServer(addIfMaxCommand);
                        break;
                    }
                    case "removeGreater": {
                        RemoveGreaterCommand removeGreaterCommand = new RemoveGreaterCommand();
                        removeGreaterCommand.userExecute();
                        clientToServerSender.sendCommandToServer(removeGreaterCommand);
                        break;
                    }
                    case "history": {
                        HistoryCommand historyCommand = new HistoryCommand();
                        historyCommand.userExecute();
                        clientToServerSender.sendCommandToServer(historyCommand);
                        break;
                    }
                    case "printDescending": {
                        DescendingCommand printDescendingCommand = new DescendingCommand();
                        printDescendingCommand.userExecute();
                        clientToServerSender.sendCommandToServer(printDescendingCommand);
                        break;
                    }
                    case "updateID": {
                        UpdateIdCommand updateIDCommand = new UpdateIdCommand();
                        updateIDCommand.setArg(wordList.get(1));
                        updateIDCommand.userExecute();
                        clientToServerSender.sendCommandToServer(updateIDCommand);
                        break;
                    }
                    case "removeByID": {
                        RemoveByIdCommand removeByIDCommand = new RemoveByIdCommand();
                        removeByIDCommand.setArg(wordList.get(1));
                        removeByIDCommand.userExecute();
                        clientToServerSender.sendCommandToServer(removeByIDCommand);
                        break;
                    }
                    case "executeScript": {

                        break;
                    }
                    case "removeAllByFuelType": {
                        RemoveAllByFuelTypeCommand removeAllByFuelTypeCommand = new RemoveAllByFuelTypeCommand();
                        removeAllByFuelTypeCommand.setArg(wordList.get(1));
                        removeAllByFuelTypeCommand.userExecute();
                        clientToServerSender.sendCommandToServer(removeAllByFuelTypeCommand);
                        break;
                    }
                    case "countByEnginePower": {
                        CountByEnginePowerCommand countByEnginePowerCommand = new CountByEnginePowerCommand();
                        countByEnginePowerCommand.setArg(wordList.get(1));
                        countByEnginePowerCommand.userExecute();
                        clientToServerSender.sendCommandToServer(countByEnginePowerCommand);
                        break;
                    }
                    case "exit": {
                        ExitCommand exitCommand = new ExitCommand();
                        exitCommand.userExecute();
                        clientToServerSender.sendCommandToServer(exitCommand);
                        break commandInput;
                    }
                }
            }
        }
    }

    private static String check(String s) {

        List<String> wordList = new ArrayList<>(Arrays.asList(s.split(" ")));
        wordList.removeAll(Arrays.asList("", null));

        switch (wordList.size()) {
            case 1: {
                if (wordList.get(0).equals("help")) {
                    return "help";
                }
                if (wordList.get(0).equals("info")) {
                    return "info";
                }
                if (wordList.get(0).equals("show")) {
                    return "show";
                }
                if (wordList.get(0).equals("add")) {
                    return "add";
                }
                if (wordList.get(0).equals("clear")) {
                    return "clear";
                }
                if (wordList.get(0).equals("exit")) {
                    return "exit";
                }
                if (wordList.get(0).equals("add_if_max")) {
                    return "addIfMax";
                }
                if (wordList.get(0).equals("remove_greater")) {
                    return "removeGreater";
                }
                if (wordList.get(0).equals("history")) {
                    return "history";
                }
                if (wordList.get(0).equals("print_descending")) {
                    return "printDescending";
                }
                return "wrong";
            }
            case 2: {
                if (wordList.get(0).equals("update")) {
                    return "updateID";
                }
                if (wordList.get(0).equals("remove_by_id")) {
                    return "removeByID";
                }
                if (wordList.get(0).equals("execute_script")) {
                    return "executeScript";
                }
                if (wordList.get(0).equals("remove_all_by_fuel_type")) {
                    return "removeAllByFuelType";
                }
                if (wordList.get(0).equals("count_by_engine_power")) {
                    return "countByEnginePower";
                }
            }
            return "wrong";
        }
        return "wrong";
    }

}
