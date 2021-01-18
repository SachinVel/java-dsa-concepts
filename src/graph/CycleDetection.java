package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.GapContent;

class Graph{
	private int v;
	private List<List<Integer>> adj;
	public Graph(int v) {
		this.v = v+1;
		adj = new ArrayList<List<Integer>>(v+1);
		for( int i=0 ; i<v+1 ; ++i ) {
			adj.add(new LinkedList<Integer>());
		}
	}
	public void addEdge(int source,int destination) {
		adj.get(source).add(destination);
	}
	private boolean isCyclicUtil(int currNode,boolean[] visited,boolean[] recStack) {
		if( recStack[currNode] ) {
			return true;
		}
		if( visited[currNode] ) {
			return false;
		}
		visited[currNode] = true;
		recStack[currNode] = true;
		for( int childNode : adj.get(currNode) ) {
			if( isCyclicUtil(childNode,visited,recStack)) {
				return true;
			}
		}
		recStack[currNode]  = false;
		return false;
	}
	public boolean isCyclic() {
		boolean visited[] = new boolean[v];
		boolean recStack[] = new boolean[v];
		for( int i=0 ; i<v ; ++i ) {
			if( isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
}
public class CycleDetection {
	public static void main(String[] args) {
		Graph graph = new Graph(4);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 2);
		System.out.println(graph.isCyclic());
	}
}
