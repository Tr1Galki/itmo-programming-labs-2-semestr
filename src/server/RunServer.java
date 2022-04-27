package server;

import file.FileManager;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;

/**
 * The type Run server.
 */
public class RunServer {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {

        Handler serverFileHandler = null;
        try {
            serverFileHandler = new FileHandler("ServerLogs.log");
        } catch (IOException e) {
            System.out.println("Logger problems");
        }
        FileManager.log.setUseParentHandlers(false);
        FileManager.log.addHandler(serverFileHandler);

        new ServerConnectionManager().start();
    }

}
