package server;

import data.registrations.AuthorizingInputData;
import data.registrations.AuthorizingOutputData;
import server.dataBase.DatabaseManager;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class ClientManager {

    private HashMap<String, String> users = new HashMap<>();

    public AuthorizingOutputData startAuthorizing(AuthorizingInputData inputData) {
        AuthorizingOutputData output;

        users = DatabaseManager.getFromDatabase();

        switch (inputData.getRegistrationType()) {
            case REGISTRATION:
                output = registration(inputData);
                break;
            case SIGNING:
                output = signing(inputData);
                break;
            default:
                output = new AuthorizingOutputData();
        }

        return output;
    }

    private AuthorizingOutputData registration(AuthorizingInputData inputData) {
        AuthorizingOutputData output = new AuthorizingOutputData();

        boolean isLoginUsed = users.containsKey(inputData.getLogin());
        if (isLoginUsed) {
            output.setLogged(false);
            output.setMassage("this_login_is_already_exist");
        } else {
            users.put(inputData.getLogin(), hashPassword(inputData.getPassword()));
            DatabaseManager.addLoginToDatabase(inputData.getLogin(), hashPassword(inputData.getPassword()));
            output.setLogged(true);
        }
        return output;
    }

    private AuthorizingOutputData signing(AuthorizingInputData inputData) {
        AuthorizingOutputData output = new AuthorizingOutputData();

        boolean isLoginUsed = users.containsKey(inputData.getLogin());
        if (isLoginUsed) {
            if (users.get(inputData.getLogin()).equals(hashPassword(inputData.getPassword()))) {
                output.setLogged(true);
                output.setMassage(" authorizing completed");
            } else {
                output.setLogged(false);
                output.setMassage("password is incorrect");
            }
        } else {
            output.setLogged(false);
            output.setMassage("There is no one user with this login");
        }

        return output;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger hash = new BigInteger(1, digest);
            String hashPass = hash.toString(16);
            while (hashPass.length() < 32) {
                hashPass = "0" + hashPass;
            }
            return hashPass;

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Неверный алгоритм хеширования");
            ;
        }
        return null;
    }

}
