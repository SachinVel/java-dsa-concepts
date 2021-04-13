package linkedlist;

public class FindMiddle {
	static class Node{
		int data;
		Node nextNode;
		Node( int data ){
			this.data = data;
			this.nextNode = null;
		}
	}
	
	public static Node insertNode(Node headNode , int data ) {
		Node newNode = new Node(data);
		if( headNode==null ) {
			return newNode;
		}
		Node traverseNode = headNode;
		while( traverseNode.nextNode!=null ) {
			traverseNode = traverseNode.nextNode;
		}
		traverseNode.nextNode = newNode;
		return headNode;
	}
	
	public static void printLinkedList( Node head ) {
		while( head!=null ) {
			System.out.print(head.data+" ");
			head = head.nextNode;
		}
		System.out.println();
	}
	
	public static Node findMiddle( Node head ) {
		
		if( head==null ) {
			return head;
		}
		Node slowPtr=head, fastPtr=head.nextNode;
		while( fastPtr!=null && fastPtr.nextNode!=null ) {
			slowPtr = slowPtr.nextNode;
			fastPtr = fastPtr.nextNode.nextNode;
		}
		return slowPtr;
		
	}
	
	public static void main(String[] args) {
		Node head = null;
		
		head = insertNode(head, 5);
		head = insertNode(head, 3);
		head = insertNode(head, 2);
		head = insertNode(head, 4);
		head = insertNode(head, 1);
		head = insertNode(head, 6);
		
		printLinkedList(head);
		
		Node middleNode = findMiddle(head);
		System.out.println("Middle Node : "+middleNode.data);
		
	}
}
