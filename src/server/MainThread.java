package server;

import commands.Command;
import data.registrations.AuthorizingInputData;
import data.registrations.AuthorizingOutputData;
import file.FileManager;
import server.ServerCollection;
import server.ServerConnectionManager;
import server.ClientManager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainThread extends Thread {

    ServerCollection serverCollection;
    ClientManager clientManager;
    ServerSocket serverSocket;
    AuthorizingOutputData registerAnswer;
    Socket client;

    public MainThread(ServerCollection serverCollection, ClientManager clientManager, Socket client) {
        serverSocket = ServerConnectionManager.serverSocket;
        this.serverCollection = serverCollection;
        this.clientManager = clientManager;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            while (!client.isClosed()) {
                AuthorizingInputData thisRegistrationData = (AuthorizingInputData) objectInputStream.readObject();
                if (thisRegistrationData.isExit()) {
                    outputStream.writeUTF("Disconnected");
                    FileManager.log.info("User Exit. Disconnected");
                    ServerConnectionManager.skip = true;
                    break;
                }
                registerAnswer = clientManager.startAuthorizing(thisRegistrationData);
                if (registerAnswer.isLogged()) break;
                objectOutputStream.writeObject(registerAnswer);
            }
            objectOutputStream.writeObject(registerAnswer);

            if (!ServerConnectionManager.skip) {
                while (!client.isClosed()) {
                    Command thisCommand = (Command) objectInputStream.readObject();
                    if (thisCommand.getArg().equals("EXIT")) {
                        outputStream.writeUTF("Disconnected");
                        serverCollection.save();
                        FileManager.log.info("User Exit. Disconnected");
                        break;
                    }
                    outputStream.writeUTF(serverCollection.executeCommand(thisCommand));
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
