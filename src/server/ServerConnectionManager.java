package server;


import data.registrations.AuthorizingOutputData;
import file.FileManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The type Server connection manager.
 */
public class ServerConnectionManager extends Thread{

    private AuthorizingOutputData registerAnswer;

    private boolean isLogged;

    public static boolean skip = false;

    /**
     * The Server collection.
     */
    private final ServerCollection serverCollection = new ServerCollection();

    private final ClientManager clientManager = new ClientManager();

    public static ServerSocket serverSocket;

    static {
        try {
            serverSocket = new ServerSocket(2288);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Connect.
     */
    public void run() {
        FileManager.log.info("Trying to connect");
        while (true) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("new user connect!");
                FileManager.log.info("New user connect");

                new MainThread(serverCollection, clientManager, client).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
