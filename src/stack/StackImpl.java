package src.stack;

public class StackImpl {

    static class Stack{
        int storage[];
        int sizeLimit;
        int topPointer;

        Stack(int sizeLimit ){
            storage = new int[sizeLimit];
            this.sizeLimit = sizeLimit;
            topPointer = -1;
        }

        private boolean checkIfStackLimitReached(){
            return topPointer>=(sizeLimit-1);
        }

        void push(int data ) throws StackOverflowException{
            if( checkIfStackLimitReached() ){
                throw new StackOverflowException(sizeLimit);
            }
            storage[++topPointer] = data;
        }

        int pop() throws StackEmptyException{
            if( topPointer==-1 ){
                throw new StackEmptyException();
            }
            return storage[topPointer--];
        }

        int peek() throws StackEmptyException{
            if( topPointer==-1 ){
                throw new StackEmptyException();
            }
            return storage[topPointer];
        }
    }

    public static void main( String args[] ) throws Exception{

        Stack stack = new Stack(10);
        stack.push(10);
        stack.push(11);

        System.out.println("Peek : "+stack.peek());

        System.out.println("pop : "+stack.pop());

        System.out.println("peek :"+stack.peek());

    }
}
