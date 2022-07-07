package src.stack;

public class StackImplUsingLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data ){
            this.data = data;
            next = null;
        }
    }
    static class Stack{
        Node head;

        Stack(){
            head = null;
        }

        void push( int data ){
            Node newNode = new Node(data);
            if( head==null ){
                head = newNode;
            }else{
                newNode.next = head;
                head = newNode;
            }
        }

        int pop() throws StackEmptyException{
            if( head==null ){
                throw new StackEmptyException();
            }
            int curData = head.data;
            head = head.next;
            return curData;
        }

        int peek() throws StackEmptyException{
            if( head==null ){
                throw new StackEmptyException();
            }
            int curData = head.data;
            return curData;
        }
    }

    public static void main( String args[] ) throws Exception{

        StackImpl.Stack stack = new StackImpl.Stack(10);
        stack.push(10);
        stack.push(11);

        System.out.println("Peek : "+stack.peek());

        System.out.println("pop : "+stack.pop());

        System.out.println("peek :"+stack.peek());

    }

}
