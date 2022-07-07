package src.stack;

public class StackOverflowException extends Exception {

    public StackOverflowException(int size){
        super("The stack of size "+size+" is already full");
    }
}
