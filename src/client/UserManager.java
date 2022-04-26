package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static client.StaticSocket.getClientSocket;

public class UserManager {

    private static Socket clientSocket;

    private ObjectInputStream inputStream;

    private ObjectOutputStream outputStream;

    private DataInputStream dataInputStream;

     public static String login;

    public void startClientConnection() {

        try {
            clientSocket = getClientSocket();
            outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            inputStream = new ObjectInputStream(clientSocket.getInputStream());
            dataInputStream = new DataInputStream(clientSocket.getInputStream());

            UserAuthorizeManager clientRegisterManager = new UserAuthorizeManager(inputStream, outputStream);

            int reg = clientRegisterManager.startRegister();
            if (reg == 1) {
                UserCommandManager userCommandManager = new UserCommandManager(outputStream, dataInputStream);
                userCommandManager.startConsole(false);
            } else {
                UserCommandManager userCommandManager = new UserCommandManager(outputStream, dataInputStream);
                System.out.println("so good buy");
                userCommandManager.startConsole(true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
