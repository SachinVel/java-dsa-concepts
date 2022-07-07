package src.queue;

public class QueueImpl {

    public static class Queue{
        int storage[];
        int size;
        int front;
        int rear;
        int curCapacity;

        public Queue(int size){
            storage = new int[size];
            front = 0;
            rear = -1;
            this.size = size;
            this.curCapacity = 0;
        }

        public void enqueue( int data ) throws QueueOverflowException{
            if( curCapacity>=size ){
                throw new QueueOverflowException(size);
            }
            rear = (rear+1)%size;
            storage[rear] = data;
            ++curCapacity;
        }

        public int dequeue() throws QueueEmptyException{
            if( curCapacity==0 ){
                throw new QueueEmptyException();
            }
            int topData = storage[front];
            front = (front+1)%size;
            --curCapacity;
            return topData;
        }

        public boolean isEmpty(){
            return curCapacity==0;
        }

        public int getCapacity(){
            return curCapacity;
        }
    }

    public static void main(String args[] ) throws Exception{
        Queue queue = new Queue(10);
        queue.enqueue(10);
        queue.enqueue(12);
        System.out.println("Queue top elem : "+queue.dequeue());
        System.out.println("Queue top elem : "+queue.dequeue());


    }
}
