package Exceptions;

public class ExecuteScriptRecursiveException extends Exception{
    public ExecuteScriptRecursiveException() {
        super("Your file has recursion. It can not be execute, sorry :(");
    }
}
