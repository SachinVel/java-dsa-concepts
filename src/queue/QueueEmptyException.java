package src.queue;

public class QueueEmptyException extends Exception {

    QueueEmptyException(){
        super("Queue is empty");
    }
}
