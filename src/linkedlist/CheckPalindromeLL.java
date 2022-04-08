package linkedlist;

import java.util.Stack;

public class CheckPalindromeLL {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node insertNode(Node head, int data) {
		Node newNode = new Node(data);
		if( head==null ) {
			return newNode;
		}else {
			Node traversalNode = head;
			while( traversalNode.next!=null ) {
				traversalNode = traversalNode.next;
			}
			traversalNode.next = newNode;
		}
		return head;
	}
	
	public static boolean checkPalindrome(Node head) {
		
		boolean isPalindrome = true;
		Node slowPtr = head, fastPtr = head.next;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(slowPtr.data);
		while( fastPtr!=null && fastPtr.next!=null ) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			stack.push(slowPtr.data);
		}
		
		slowPtr = slowPtr.next;
		
		if( fastPtr==null ) {
			stack.pop();
		}
		
		
		while( slowPtr!=null ) {
			if( slowPtr.data!=stack.peek() ) {
				return false;
			}
			stack.pop();
			slowPtr = slowPtr.next;
		}
		
		return isPalindrome;
	}
	
	public static void main(String args[]) {
		Node head = null;
		head = insertNode(head,1);
		head = insertNode(head,3);
		head = insertNode(head,3);
		head = insertNode(head,1);
		head = insertNode(head,3);
		head = insertNode(head,1);
		
		System.out.println(checkPalindrome(head));
	}

}
