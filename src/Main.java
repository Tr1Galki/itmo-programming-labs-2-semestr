import mainLogic.CommandManager;

import java.io.IOException;

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

        CommandManager commandmanager  = new CommandManager();

        commandmanager.start();

    }
}
