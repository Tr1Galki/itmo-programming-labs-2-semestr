package client;

import data.registrations.AuthorizingInputData;
import data.registrations.AuthorizingOutputData;
import data.registrations.RegistrationType;
import exceptions.IncorrectValueException;
import file.FileManager;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;
import java.util.Scanner;

import static client.StaticSocket.getClientSocket;

public class UserAuthorizeManager {

    private AuthorizingInputData data;

    /**
     * The Input stream.
     */
    private ObjectInputStream inputStream;
    /**
     * The Output stream.
     */
    private ObjectOutputStream outputStream;


    /**
     * Instantiates a new Client registration manager.
     */
    public UserAuthorizeManager(ObjectInputStream inputStream, ObjectOutputStream outputStream) {

        this.inputStream = inputStream;
        this.outputStream = outputStream;

    }

    Scanner scan = new Scanner(System.in);

    public int startRegister() {
        FileManager.log.info("Trying to register");
        int res;

        while (true) try {
            System.out.println("Write what do you want:\n - registration\n - sign_in");
            String input = scan.nextLine();

            switch (input.toLowerCase(Locale.ROOT)) {
                case "sign_in": {
                    res = signIn();
                    switch (res) {
                        case 0:
                            continue;
                        case 1:
                            return 1;
                    }
                    break;
                }
                case "registration": {
                    res = register();
                    switch (res) {
                        case 0:
                            continue;
                        case 1:
                            return 1;
                    }
                    break;
                }
            }

            throw new IncorrectValueException();
        } catch (IncorrectValueException e) {
            System.out.println(e.getMessage());
        }
    }

    private int register() {

        data = new AuthorizingInputData();
        data.setRegistrationType(RegistrationType.REGISTRATION);

        String input;

        while (true) {

            System.out.print("Write your login or \"exit\" to leave: ");
            input = scan.nextLine();

            if (input.equals("")) {
                System.out.println("login can not be empty :( ");
                continue;
            }
            if (input.toLowerCase(Locale.ROOT).equals("exit")) return 0;

            data = new AuthorizingInputData();
            data.setRegistrationType(RegistrationType.REGISTRATION);
            data.setLogin(input);

            break;
        }


        while (true) {

            System.out.print("Write your password or \"exit\" to leave: ");
            input = scan.nextLine();

            if (input.equals("")) {
                System.out.println("password can not be empty :( ");
                continue;
            }
            if (input.toLowerCase(Locale.ROOT).equals("exit")) return 0;

            data.setPassword(input);
            break;
        }

        UserManager.login = data.getLogin();
        AuthorizingOutputData answer = sendRegistrationToServer(data);

        if (answer.isLogged()) {
            return 1;
        }

        System.out.println(answer.getMassage());
        return register();
    }


    private int signIn() {
        data = new AuthorizingInputData();
        data.setRegistrationType(RegistrationType.SIGNING);

        String input;

        while (true) {

            System.out.print("Write your login or \"exit\" to leave: ");
            input = scan.nextLine();

            if (input.equals("")) {
                System.out.println("login can not be empty :( ");
                continue;
            }
            if (input.toLowerCase(Locale.ROOT).equals("exit")) return 0;

            data = new AuthorizingInputData();
            data.setRegistrationType(RegistrationType.SIGNING);
            data.setLogin(input);

            break;
        }


        while (true) {

            System.out.print("Write your password or \"exit\" to leave: ");
            input = scan.nextLine();

            if (input.equals("")) {
                System.out.println("password can not be empty :( ");
                continue;
            }
            if (input.toLowerCase(Locale.ROOT).equals("exit")) return 0;

            data.setPassword(input);
            break;
        }

        UserManager.login = data.getLogin();
        AuthorizingOutputData answer = sendRegistrationToServer(data);

        if (answer.isLogged()) {
            return 1;
        }

        System.out.println(answer.getMassage());
        return register();
    }


    private AuthorizingOutputData sendRegistrationToServer(AuthorizingInputData registrationData) {
        FileManager.log.info("Sending registration data to server");
        try {
            outputStream.writeObject(registrationData);
            outputStream.flush();

            FileManager.log.info("Get registration answer from server");
            return (AuthorizingOutputData) inputStream.readObject();
        } catch (StreamCorruptedException ignored) {
            AuthorizingOutputData ans = new AuthorizingOutputData();
            ans.setLogged(false);
            ans.setMassage("Ошибка передачи с сервером");
            return ans;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            AuthorizingOutputData ans = new AuthorizingOutputData();
            ans.setLogged(false);
            ans.setMassage("Ошибка передачи с сервером");
            return ans;
        }
    }
}