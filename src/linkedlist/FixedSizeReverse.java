package linkedlist;

import linkedlist.FindMiddle.Node;

public class FixedSizeReverse {
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
	
	public static Node reverseFixed(Node head,int k) {
		
		if( head==null ) {
			return head;
		}
		Node cur = head,prevNode=null, nextNode;
		int count = 0;
		while( count<k && cur!=null ) {
			nextNode = cur.nextNode;
			cur.nextNode = prevNode;
			prevNode = cur;
			cur = nextNode;
			++count;
		}
		
		head.nextNode = reverseFixed(cur, k);
		
		return prevNode;

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
		
		head = reverseFixed(head, 3);
		
		printLinkedList(head);
		
	}

}
