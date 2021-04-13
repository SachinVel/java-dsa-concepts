package linkedlist;

public class LinkedListSort {
	static Node head = null;
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static void insertNode( int data) {
		Node newNode = new Node(data);
		if( head==null ) {
			head = newNode;
		}else {
			Node temp = head;
			while( temp.next!=null ) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		
	}

	static void printList() {
		Node temp = head;
		while( temp!=null ) {
			System.out.print(temp.data);
			if( temp.next!=null ) {
				System.out.print(" -> ");
			}
			temp = temp.next;
		}
	}
	
	static Node merge(Node firstHead, Node secondHead ) {
		Node result;
		if( firstHead.data<secondHead.data ) {
			result = firstHead;
			firstHead = firstHead.next;
		}else {
			result = secondHead;
			secondHead = secondHead.next;
		}
		Node resultHead = result;
		
		while( firstHead!=null && secondHead!=null ) {
			if( firstHead.data<secondHead.data ) {
				result.next = firstHead;
				firstHead = firstHead.next;
			}else {
				result.next = secondHead;
				secondHead = secondHead.next;
			}
			result = result.next;
		}
		
		while( firstHead!=null ) {
			result.next = firstHead;
			firstHead = firstHead.next;
			result = result.next;
		}
		
		while( secondHead!=null ) {
			result.next = secondHead;
			secondHead = secondHead.next;
			result = result.next;
		}
		
		return resultHead;
		
	}
	
	static Node mergeSort(Node headNode) {
		Node fastPtr = headNode,slowPtr = headNode,prePtr=headNode;
		while( fastPtr!=null && fastPtr.next!=null ) {
			fastPtr = fastPtr.next.next;
			prePtr = slowPtr;
			slowPtr = slowPtr.next;
		}
		if( slowPtr!=fastPtr ) {
			prePtr.next=null;
			headNode = mergeSort(headNode);
			slowPtr = mergeSort(slowPtr);
			return merge(headNode,slowPtr);
		}
		return headNode;
	}
	
	public static void main(String[] args) {
		insertNode(5);
		insertNode(2);
		insertNode(3);
		insertNode(1);
		insertNode(4);
		
		printList();
		head = mergeSort(head);
		System.out.println();
		printList();
		
	 
	}
}
