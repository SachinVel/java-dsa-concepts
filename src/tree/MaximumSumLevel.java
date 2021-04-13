package tree;

import java.util.LinkedList;

public class MaximumSumLevel {
	
	static class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node( int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void inorder( Node head ){
		if( head!=null ) {
			inorder(head.left);
			System.out.print(head.data+" ");
			inorder(head.right);
		}
	}
	
	public static int maximumSum(Node head) {
		LinkedList<Node> list = new LinkedList<Node>();
		if( head==null )
			return 0;
		int max = Integer.MIN_VALUE;
		int sum;
		list.add(head);
		Node temp;
		while( !list.isEmpty() ) {
			int count = list.size();
			sum = 0;
			while( count>0 ) {
				temp = list.poll();
				sum += temp.data;
				if( temp.left!=null ) {
					list.add(temp.left);
				}
				if( temp.right!=null ) {
					list.add(temp.right);
				}
				--count;
			}
			max = Math.max(sum, max);
		}
		return max;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.right = new Node(4);
		head.left.left = new Node(5);
		head.right.right = new Node(8);
		head.right.right.left = new Node(6);
		head.right.right.right = new Node(7);
		
		System.out.println();
		inorder(head);
		System.out.println();
		
		System.out.println(maximumSum(head));
		
	}
}
