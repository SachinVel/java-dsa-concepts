package src.stack;

import src.queue.QueueEmptyException;
import src.queue.QueueImpl.Queue;
import src.queue.QueueOverflowException;

public class StackImplUsingQueue {
    static class Stack{
        Queue primaryQueue, secondaryQueue;
        int size,curCapacity;

        Stack(int size){
            primaryQueue = new Queue(size);
            secondaryQueue = new Queue(size);
            this.size = size;
            this.curCapacity = 0;
        }

        public void push(int data ) throws StackOverflowException,QueueOverflowException{
            if( curCapacity>=size ){
                throw new StackOverflowException(size);
            }
            primaryQueue.enqueue(data);
            ++curCapacity;
        }

        public int pop() throws Exception{
            if( curCapacity==0 ){
                throw new StackEmptyException();
            }
            int curData=-1;
            while( !primaryQueue.isEmpty() ){
                curData = primaryQueue.dequeue();
                if( primaryQueue.getCapacity()!=0 ){
                    secondaryQueue.enqueue(curData);
                }
            }
            Queue tempQueue = primaryQueue;
            primaryQueue = secondaryQueue;
            secondaryQueue = tempQueue;
            --curCapacity;
            return curData;
        }

    }

    public static void main(String args[]) throws Exception{
        Stack stack = new Stack(10);
        stack.push(12);
        stack.push(9);
        stack.push(8);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
