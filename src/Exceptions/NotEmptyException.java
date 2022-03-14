package Exceptions;

public class NotEmptyException extends Exception{
    public NotEmptyException(){
        super("Element can not be empty");
    }
}
