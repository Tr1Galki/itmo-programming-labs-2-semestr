package server;


import commands.Command;
import file.FileManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server connection manager.
 */
public class ServerConnectionManager {

    /**
     * The Server collection.
     */
    private final ServerCollection serverCollection = new ServerCollection();

    /**
     * Connect.
     */
    public void connect(){
        FileManager.log.info("Trying to connect");
        try {

            ServerSocket serverSocket = new ServerSocket(2288);
            Socket client = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("new user connect!");
            FileManager.log.info("New user connect");

            while (!client.isClosed()){
                Command thisCommand = (Command) objectInputStream.readObject();
                if (thisCommand.getArg().equals("EXIT")){
                    outputStream.writeUTF("Disconnected");
                    serverCollection.save();
                    FileManager.log.info("User Exit. Disconnected");
                    break;
                }
                outputStream.writeUTF(serverCollection.executeCommand(thisCommand));
               }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
