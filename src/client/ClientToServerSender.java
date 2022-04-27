package client;

import commands.Command;
import file.FileManager;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static client.StaticSocket.getClientSocket;

/**
 * The type Client to server sender.
 */
public class ClientToServerSender {

    /**
     * The Input stream.
     */
    private DataInputStream inputStream;

    /**
     * The Object output stream.
     */
    private ObjectOutputStream objectOutputStream;

    /**
     * Instantiates a new Client to server sender.
     */
    public ClientToServerSender(ObjectOutputStream objectOutputStream, DataInputStream inputStream) {

        this.objectOutputStream = objectOutputStream;
        this.inputStream = inputStream;

    }

    /**
     * Send command to server.
     *
     * @param command Command
     */
    public void sendCommandToServer(Command command) {
        FileManager.log.info("Sending command to server");
        try {
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();

            FileManager.log.info("Get command from server");
            System.out.println(inputStream.readUTF());

        } catch (SocketException ignored){
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}