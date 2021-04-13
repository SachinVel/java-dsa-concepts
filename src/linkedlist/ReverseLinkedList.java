package linkedlist;

import javax.naming.NoPermissionException;

import linkedlist.LinkedListSort.Node;

public class ReverseLinkedList {
	
	static class Node{
		int data;
		Node next;
		
		Node( int data ){
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node insertNode(Node headNode , int data ) {
		Node newNode = new Node(data);
		if( headNode==null ) {
			return newNode;
		}
		Node traverseNode = headNode;
		while( traverseNode.next!=null ) {
			traverseNode = traverseNode.next;
		}
		traverseNode.next = newNode;
		return headNode;
	}
	
	public static void printLinkedList( Node head ) {
		while( head!=null ) {
			System.out.print(head.data+" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static Node reverseList(Node head) {
		if( head==null ) {
			return head;
		}
		
		Node prevNode = null,curNode = head,nextNode;
		while( curNode!=null ) {
			nextNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
		}
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
		
		head = reverseList(head);
		
		printLinkedList(head);
	}
}
