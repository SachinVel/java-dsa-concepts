package tree;

public class BSTLevelUp {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data  = data;
			this.left = null;
			this.right = null;
		}
	
	}
	
	public static Node insertNode(Node head, int data) {
		if(head==null ) {
			Node newNode = new Node(data);
			return newNode;
		}
		if( data<head.data ) {
			head.left = insertNode(head.left,data);
		}else {
			head.right = insertNode(head.right,data);
		}
		return head;
	}
	
	public static void inorder(Node head) {
		if( head!=null ) {
			inorder(head.left);
			System.out.print(head.data+" ");
			inorder(head.right);
		}
	}
	
	
	
	public static void main(String args[]) {
		Node head = null;
		
		head = insertNode(head,2);
		head = insertNode(head,1);
		head = insertNode(head,3);
		
		inorder(head);
		
	}
}
