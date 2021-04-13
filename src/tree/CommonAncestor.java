package tree;

import java.awt.List;
import java.util.ArrayList;

public class CommonAncestor {
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node insertNode(Node head,int data) {
		Node newNode = new Node(data);
		if( head==null ) {
			return head;
		}
		if( data<head.data ) {
			head.left = insertNode(head.left, data);
		}else if( data>head.data ) {
			head.right = insertNode(head.right, data);
		}
		return head;
	}
	
	public static boolean findPath(Node head, int data,ArrayList<Integer> curPath) {
		

		if( head==null ) {
			return false;
		}
		
		if( head.data==data ) {
			return true;
		}
		
		curPath.add(head.data);
		
		if( head.left!=null && findPath(head.left, data, curPath) ) {
			return true;
		}
		
		if( head.right!=null && findPath(head.right, data, curPath) ) {
			return true;
		}
		
		curPath.remove(curPath.size()-1);
		
		return false;
		
	}
	
	public static int findCommonAncestor(Node head,int data1, int data2) {
		ArrayList<Integer> path1 = new ArrayList<Integer>();
		ArrayList<Integer> path2 = new ArrayList<Integer>();
		
		boolean isFirstFound = findPath(head, data1, path1);
		boolean isSecondFound = findPath(head, data2, path2);
		if( !isFirstFound && !isSecondFound ) {
			return -1;
		}
		
		System.out.println("path1 : "+path1);
		System.out.println("path2 : "+path2);
		
		int commondNodeData = -1;
		
		int minLen = Math.min(path1.size(),path2.size());
		for( int commInd=0 ; commInd<minLen ; ++commInd ) {
			if( path1.get(commInd)==path2.get(commInd) ) {
				commondNodeData = path1.get(commInd);
			}
		}
		
		return commondNodeData;
		
	}
	
	public static void main(String[] args) {
		
		Node head = null;
		head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        
        System.out.println(findCommonAncestor(head, 4, 5));
        
        
        
        
		
	}
}
