package exceptions;

/**
 * Exception triggered when element is empty.
 *
 * @author Alever
 */
public class NotEmptyException extends Exception{
    /**
     * Instantiates a new Not empty exception.
     */
    public NotEmptyException(){
        super("Element can not be empty");
    }
}
