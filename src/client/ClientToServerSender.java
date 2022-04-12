package client;

import commands.Command;
import file.FileManager;

import java.io.*;
import java.net.Socket;

/**
 * The type Client to server sender.
 */
public class ClientToServerSender {

    /**
     * The constant clientSocket.
     */
    private static Socket clientSocket;

    /**
     * The Input stream.
     */
    private DataInputStream inputStream;
    /**
     * The Output stream.
     */
    private DataOutputStream outputStream;

    /**
     * The Keyboard.
     */
    private BufferedReader keyboard;

    /**
     * The Object output stream.
     */
    private ObjectOutputStream objectOutputStream;

    /**
     * Instantiates a new Client to server sender.
     */
    public ClientToServerSender(){
        try{
            clientSocket = new Socket("localhost", 2288);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new DataInputStream(clientSocket.getInputStream());
            outputStream = new DataOutputStream(clientSocket.getOutputStream());
            keyboard=new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) {
            System.out.println("Сервер закрыт, попробуйте позже");
            System.exit(228);
        }
    }

    /**
     * Send command to server.
     *
     * @param command Command
     */
    public void sendCommandToServer(Command command){
        FileManager.log.info("Sending command to server");
        try {
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();

            FileManager.log.info("Get command from server");
            System.out.println(inputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}