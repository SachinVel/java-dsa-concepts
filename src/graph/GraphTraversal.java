package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.Cipher;

import dynamicprogramming.EditDistance;

public class GraphTraversal {
	static class Graph{
		int n;
		List<List<Integer>> edges;
		
		public Graph(int n) {
			this.n = n;
			edges = new ArrayList<List<Integer>>(n);
			for( int itr=1 ; itr<=n ; ++itr ) {
				ArrayList<Integer> innerList = new ArrayList<Integer>();
				edges.add(innerList);
			}
		}
		
		public void addEdge(int from,int to) {
			edges.get(from).add(to);
		}
		
		public void bfs(int startNode) {
			boolean visited[] = new boolean[n];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(startNode);
			visited[startNode] = true;
			while( !queue.isEmpty() ) {
				int curNode = queue.pollFirst();
				System.out.print(curNode+" ");
				for( int toNode : edges.get(curNode) ) {
					if( !visited[toNode] ) {
						visited[toNode] = true;
						queue.add(toNode);
					}
				}
			}
			System.out.println();
		}
		
		public void dfsUtil(int curNode,boolean visited[]) {
			visited[curNode] = true;
			System.out.print(curNode+" ");
			for( int toNode : edges.get(curNode) ) {
				if( !visited[toNode] ) {
					dfsUtil(toNode, visited);
				}
			}
		}
		
		public void dfs(int startNode) {
			boolean visited[] = new boolean[n];
			dfsUtil(startNode, visited);
		}
		
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("BFS : ");
		graph.bfs(2);
		
		System.out.println("DFS : ");
		graph.dfs(2);
	}
}
