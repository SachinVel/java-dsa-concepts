package src.stack;

/*
    This stack returns minimum most element present in stack at any given time
 */

public class MinStack {

    static class Stack{
        int storage[];
        int sizeLimit;
        int topPointer, minElem;

        Stack(int sizeLimit ){
            storage = new int[sizeLimit];
            this.sizeLimit = sizeLimit;
            topPointer = -1;
            minElem = Integer.MAX_VALUE;
        }

        private boolean checkIfStackLimitReached(){
            return topPointer>=(sizeLimit-1);
        }

        void push(int data ) throws StackOverflowException{
            if( checkIfStackLimitReached() ){
                throw new StackOverflowException(sizeLimit);
            }
            if( topPointer==-1 ){
                minElem = data;
            }else{
                if( data<minElem ){
                    int prevMin = minElem;
                    minElem = data;
                    data = data-prevMin;
                }
            }
            storage[++topPointer] = data;
        }

        int pop() throws StackEmptyException{
            if( topPointer==-1 ){
                throw new StackEmptyException();
            }
            int curData = storage[topPointer--];
            if( curData<minElem){
                int curElem = minElem;
                minElem = minElem - curData;
                return curElem;
            }
            return curData;
        }

        int peek() throws StackEmptyException{
            if( topPointer==-1 ){
                throw new StackEmptyException();
            }
            return storage[topPointer];
        }

        int getMinElem() throws StackEmptyException{
            if( topPointer==-1 ){
                throw new StackEmptyException();
            }
            return minElem;
        }
    }

    public static void main( String args[]) throws Exception{
        Stack stack = new Stack(10);
        stack.push(2);
        System.out.println(stack.getMinElem());
        stack.push(-1);
        System.out.println(stack.getMinElem());
        stack.pop();
        System.out.println(stack.getMinElem());
    }
}
