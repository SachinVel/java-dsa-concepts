package src.queue;

public class QueueOverflowException extends Exception{
    QueueOverflowException(int size){
        super("The Queue of size "+size+" is full.");
    }
}
