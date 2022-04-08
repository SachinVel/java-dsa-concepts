package linkedlist;

/*
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
	
	Node head=null;
	
	private static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node insertNode(int data,Node head) {
		Node newNode = new Node(data);
		if( head==null ) {
			return newNode;
		}
		Node itr = head;
		while( itr.next!=null ) {
			itr = itr.next;
		}
		itr.next = newNode;
		
		return head;
	}
	
	public static void printLinkedList(Node head) {
		Node itr = head;
		System.out.println();
		while( itr!=null ) {
			System.out.print(itr.data);
			if( itr.next!=null ) {
				System.out.print(" --> ");
			}
			itr = itr.next;
		}
	}
	
	public static Node addTwoNumbers(Node head1, Node head2) {
		Node result = null;
		int currentDigit,carryover=0;
		while( head1!=null && head2!=null ) {
			currentDigit=carryover;
			if( head1!=null ) {
				currentDigit += head1.data;
				head1 = head1.next;
			}
			
			if( head2!=null ) {
				currentDigit += head2.data;
				head2 = head2.next;
			}
			if( currentDigit>=10 ) {
				carryover = currentDigit/10;
				currentDigit = currentDigit%10;
			}
			result = insertNode(currentDigit, result);
		}
		
		return result;
		
	}
	
	public static void main(String args[]) {
		Node head1 = null;
		Node head2 = null;
		
		head1 = insertNode(2, head1);
		head1 = insertNode(4, head1);
		head1 = insertNode(3, head1);
		
		head2 = insertNode(5, head2);
		head2 = insertNode(6, head2);
		head2 = insertNode(4, head2);
		
		printLinkedList(head1);
		printLinkedList(head2);
		
		Node result = addTwoNumbers(head1, head2);
		
		printLinkedList(result);
		
	}
}
