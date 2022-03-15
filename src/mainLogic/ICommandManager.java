package mainLogic;

import java.io.IOException;

/**
 * The interface of Command manager.
 *
 * @author Alever
 */
public interface ICommandManager {
    /**
     * Start.
     * Main method which running interactive part of program.
     *
     * @throws IOException the io exception-_-
     */
    void start() throws IOException;

    /**
     * Checking valid of commands.
     *
     * @param s the command in String format
     * @return String format of normal command
     */
    String check(String s);
}
