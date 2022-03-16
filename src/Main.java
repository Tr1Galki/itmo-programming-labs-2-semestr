import com.google.gson.JsonParseException;
import file.FileManager;
import mainLogic.CommandManager;

import java.io.IOException;
import java.util.logging.*;


/**
 * Main class, not more
 * @author Alever
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception-_-
     */
    public static void main(String[] args) throws IOException {

        Handler FileHandler = new FileHandler("MyLogs.log");
        FileManager.log.setUseParentHandlers(false);
        FileManager.log.addHandler(FileHandler);

        CommandManager commandmanager  = new CommandManager();

        commandmanager.start();

    }
}
