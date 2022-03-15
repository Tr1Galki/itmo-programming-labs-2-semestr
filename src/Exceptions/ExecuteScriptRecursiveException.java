package Exceptions;

/**
 * Exception triggered when script recursive problem is found.
 *
 * @author Alever
 */
public class ExecuteScriptRecursiveException extends Exception{
    /**
     * Instantiates a new Execute script recursive exception
     */
    public ExecuteScriptRecursiveException() {
        super("Your file has recursion. It can not be execute, sorry :(");
    }
}
