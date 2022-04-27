package exceptions;

/**
 * Exception triggered value is incorrect.
 *
 *  @author Alever
 */
public class IncorrectValueException extends Exception{
    /**
     * Instantiates a new Incorrect value exception.
     */
    public IncorrectValueException(){
        super("Value is incorrect");
    }
}
