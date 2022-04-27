package exceptions;

public class SameLoginException extends Exception {
    public SameLoginException(){
        super("This login is already used");
    }
}
