package commands.commandCollection;

import commands.Command;

import java.util.HashMap;

public class HelpCommand extends Command {

    @Override
    public void userExecute() {
        setName("help");

        final HashMap<String, String> commandList = new HashMap<>();
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

        System.out.println("All enable commands:");

        for (HashMap.Entry<String, String> item : commandList.entrySet()) {
            System.out.print(item.getKey() + ": " + item.getValue() + "\n");
        }
    }
}
