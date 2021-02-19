package linkedlist;

import linkedlist.FixedSizeReverse.Node;

public class LinkedListLoop {
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
	
	public static void detectLoop(Node head ) {
		Node slowPtr = head, fastPtr = head;
		while( slowPtr!=null && fastPtr!=null && fastPtr.nextNode!=null) {
			slowPtr = slowPtr.nextNode;
			fastPtr = fastPtr.nextNode.nextNode;
			if( slowPtr.data == fastPtr.data ) {
//				removeLoop(head,fastPtr);
				System.out.println("Length of loop : "+findLength(slowPtr));
			}
		}
		
	}
	
	public static int findLength(Node loop) {
		Node ptr = loop;
		int len=1;
		while( ptr.nextNode!=loop ) {
			++len;
			ptr = ptr.nextNode;
		}
		return len;
	}
	
	
	
	public static void removeLoop( Node head , Node loop) {
		Node ptr1 = head;
		Node ptr2;
		boolean isEndFound = false;
		while( true ) {
			ptr2 = loop;
			while( ptr2.nextNode!=loop && ptr1!=ptr2.nextNode) {
				ptr2 = ptr2.nextNode;
			}
			
			if(  ptr1==ptr2.nextNode ) {
				ptr2.nextNode = null;
				break;
			}			

			ptr1 = ptr1.nextNode;
		}
	}
	
	public static Node findFirstNodeLoop(Node head) {
		Node slowPtr=head ,fastPtr = head ;
		while( slowPtr!=null && fastPtr!=null && fastPtr.nextNode!=null ) {
			slowPtr = slowPtr.nextNode;
			fastPtr = fastPtr.nextNode.nextNode;
			if( slowPtr==fastPtr ) {
				Node ptr1 = head;
				Node ptr2 = slowPtr;
				while( true ) {
					while( ptr2.nextNode!=slowPtr && ptr2.nextNode!=ptr1 ) {
						ptr2 = ptr2.nextNode;
					}
					if( ptr2.nextNode == ptr1 ) {
						return ptr1;
					}
					ptr1 = ptr1.nextNode;
				}
			}
		}
		return null;
	}
	
	public static void dummyMethod(Node head) {
		head.data = 1;
	}
	
	public static void main(String[] args) {
		Node head = null;
		
		head = insertNode(head, 5);
		head = insertNode(head, 3);
		head = insertNode(head, 2);
		
		System.out.println(head.data);
		
		dummyMethod(head);
		
		System.out.println(head.data);
		
		
//		head.nextNode.nextNode.nextNode = head;
		
//		System.out.println(findFirstNodeLoop(head));
		
//		printLinkedList(head);
//		
//		detectLoop(head);
		
//		printLinkedList(head);
		
		
		
	}
}
