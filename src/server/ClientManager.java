package server;

import data.registrations.AuthorizingInputData;
import data.registrations.AuthorizingOutputData;

import java.util.HashMap;

public class ClientManager {

    private final HashMap<String, String> users = new HashMap<>();


    public AuthorizingOutputData startAuthorizing(AuthorizingInputData inputData) {
        AuthorizingOutputData output;

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
            users.put(inputData.getLogin(), inputData.getPassword());
            output.setLogged(true);
        }
        return output;
    }

    private AuthorizingOutputData signing(AuthorizingInputData inputData) {
        AuthorizingOutputData output = new AuthorizingOutputData();

        boolean isLoginUsed = users.containsKey(inputData.getLogin());
        if (isLoginUsed) {
            if (users.get(inputData.getLogin()).equals(inputData.getPassword())) {
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

}
