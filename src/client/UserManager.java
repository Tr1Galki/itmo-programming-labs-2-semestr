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
                userCommandManager.startConsole(true);
                System.out.println("so good buy");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
