package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class Tree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node( int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node insertNode(int data,Node head) {
		
		Node newNode = new Node(data);
		if( head==null ) {
			return newNode;
		}
		if( data<head.data ) {
			head.left = insertNode(data, head.left);
		}else if( data>head.data ) {
			head.right = insertNode(data, head.right);
		}
		return head;
		
	}
	
	public static void inorder( Node head ,List<Integer> inorder) {
		if( head!=null ) {
			inorder(head.left,inorder);
			inorder.add(head.data);
			inorder(head.right,inorder);
		}
	}
	
	public static void levelOrder( Node head, List<Integer> levelOrder) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(head);
		Node node;
		while( !queue.isEmpty() ) {
			node = queue.poll();
			levelOrder.add(node.data);
			if( node.left!=null ) {
				queue.add(node.left);
			}
			if( node.right!=null ) {
				queue.add(node.right);
			}
		}
	}
	
	public static int findHeight( Node head) {
		
		if( head==null ) {
			return 0;
		}
		if( head.left==null ) {
			return findHeight(head.right)+1;
		}else if( head.right==null ) {
			return findHeight(head.left)+1;
		}
		else{
			return Math.max(findHeight(head.left),findHeight(head.right))+1;
		}
		
	}
	
	public static int findHeightUsingTraversal( List<Integer> inorder,List<Integer> levelOrder) {
		
		if( inorder.size()==0 ) {
			return 0;
		}
		int head = levelOrder.get(0);
		int indOfHead = inorder.indexOf(head);
		List<Integer> leftSubtree =  inorder.subList(0, indOfHead);
		List<Integer> rightSubTree =  inorder.subList(indOfHead+1, inorder.size());
		List<Integer> leveOrderDuplicate = new ArrayList<Integer>(levelOrder);
		levelOrder.retainAll(leftSubtree);
		leveOrderDuplicate.retainAll(rightSubTree);
		
		return Math.max(findHeightUsingTraversal(leftSubtree, levelOrder),findHeightUsingTraversal(rightSubTree, leveOrderDuplicate))+1;
		
	}
	
	public static boolean validateBST(Node head,int minVal, int maxVal) {
		if( head==null ) {
			return true;
		}
		if( head.data>maxVal || head.data<minVal ) {
			return false;
		}
			
		return validateBST(head.left, minVal, head.data)&&validateBST(head.right, head.data, maxVal);
	}
	
	
	
	public static void main(String[] args) {
		
		int N = 7;
		
		Node head = null;
		head = insertNode(2,head);
		head = insertNode(3,head);
		head = insertNode(5,head);
//		head = insertNode(4,head);
//		head = insertNode(7,head);
//		head = insertNode(6,head);
		head = insertNode(1,head);
		
		List<Integer> inorder  = new ArrayList<Integer>();
		List<Integer> levelOrder = new ArrayList<Integer>();
		
		inorder(head,inorder);
		System.out.println("Inorder -> "+inorder);
		
		levelOrder(head, levelOrder);
		System.out.println("Level order -> "+levelOrder);
		
		System.out.println();
		System.out.println("Height using tree -> "+findHeight(head));
		System.out.println("Height using traversal -> "+findHeightUsingTraversal(inorder,levelOrder));
//		
		
		
		
		
		
		
		
		
	}
}	
