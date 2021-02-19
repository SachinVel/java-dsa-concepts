package tree;

public class NodeSums {
	static class Node{
		Node left,right;
		int data;
		Node( int data ){
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static Node insertNode(Node head, int data ) {
		
		if( head==null ) {
			Node newNode = new Node(data);
			return newNode;
		}
		if( data<head.data ) {
			head.left = insertNode(head.left, data);
		}else if( data>head.data ){
			head.right = insertNode(head.right, data);
		}
		return head;
	}
	
	public static void inorder ( Node head ) {
		if( head!=null ) {
			inorder(head.left);
			System.out.print(head.data+" ");
			inorder(head.right);
		}
	}
	
	public static void preorder ( Node head ) {
		if( head!=null ) {
			System.out.print(head.data+" ");
			preorder(head.left);
			preorder(head.right);
		}
	}
	
	public static boolean isSumPresent( Node head ,int sum,int curSum) {
		
		if( curSum==sum && head == null ) {
			return true;
		}
		
		if( head==null ) {
			return false;
		}
		
		if( curSum+head.data>sum ) {
			return false;
		}
		
		return (isSumPresent(head.left, sum, curSum+head.data) || isSumPresent(head.right, sum, curSum+head.data));
	}
	
	public static void main(String[] args) {
		Node head = null;
		
		head = insertNode(head, 4);
		head = insertNode(head, 2);
		head = insertNode(head, 5);
		head = insertNode(head, 1);
		head = insertNode(head, 3);
		head = insertNode(head, 6);
		
		inorder(head);
		System.out.println();

		preorder(head);
		System.out.println();

		System.out.println("is sum present : "+isSumPresent(head, 6, 0));
		
		
		
	}
}
