package stack;

import java.util.LinkedList;
import java.util.Stack;

public class MaxInStack {
	static class MaxStack{
		Stack<Integer> stack;
		int maxElem;
		public MaxStack() {
			stack = new Stack<Integer>();
			maxElem = -1;
		}
		public void push(int elem) {
			if( stack.isEmpty() ) {
				stack.push(elem);
				maxElem = elem;
			}else {
				if( elem>maxElem ) {
					int modifiedElem = 2*elem-maxElem;
					stack.push(modifiedElem);
					maxElem = elem;
				}else {
					stack.push(elem);
				}
			}
		}
		
		public int getMax() {
			return maxElem;
		}
		
		public int pop() {
			int elem = stack.pop();
			int originalElem = elem;
			if( elem>maxElem ) {
				originalElem = maxElem;
				maxElem = 2*maxElem-elem;
			}
			return originalElem;
		}
	}
	public static void main(String[] args) {
		MaxStack s = new MaxStack();
		s.push(3); 
	    s.push(5); 
	    System.out.println(s.getMax()); 
	    s.push(7); 
	    s.push(19); 
	    System.out.println(s.getMax()); 
	    System.out.println(s.pop());
	    System.out.println(s.getMax());
	    s.pop(); 
 	    System.out.println(s.hashCode());
	}
}
