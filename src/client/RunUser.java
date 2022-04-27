package client;

import file.FileManager;

import java.io.IOException;
import java.util.logging.*;


/**
 * client.Main class, not more
 * @author Alever
 */
public class RunUser {

    /**
     * The entry point of application.
     * @param args the input arguments
     * @throws IOException the io exception-_-
     */
    public static void main(String[] args) {

        Handler userFileHandler = null;
        try {
            userFileHandler = new FileHandler("UserLogs.log");
        } catch (IOException e) {
            System.out.println("Logger problems");
        }
        FileManager.log.setUseParentHandlers(false);
        FileManager.log.addHandler(userFileHandler);

        UserManager userManager = new UserManager();
        userManager.startClientConnection();

    }
}
