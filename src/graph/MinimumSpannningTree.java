package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MinimumSpannningTree {
	static class Edge {
		int source,destination,weight;
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.weight = weight;
			this.destination = destination;			
		}
		public String toString() {
			return this.source+" ----> "+this.destination+" weight : "+this.weight;
		}
	}
	static class Graph{
		int n;
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		public Graph( int n,int totalEdges) {
			this.n = n;
			edges = new ArrayList<Edge>();
		}
		
		public void addEdge(int source,int destination, int weight ) {
			edges.add(new Edge(source, destination, weight));
		}		
		
		public int findParent(int parent[],int nodeInd) {
			if( parent[nodeInd]==nodeInd ) {
				return nodeInd;
			}
			return findParent(parent, parent[nodeInd]);
		}
		
		public void printKrustkalMST() {
			Collections.sort(edges, (edge1,edge2)->{
				return edge1.weight-edge2.weight;
			});
			
			int parent[] = new int[n];
			for( int ind=0 ; ind<n ; ++ind ) {
				parent[ind] = ind;
			}
			
			int edgesInserted=0;
			for( Edge edge : edges ) {
				int sourceParent = findParent(parent, edge.source);
				int destParent = findParent(parent, edge.destination);
				if( sourceParent!=destParent ) {
					parent[destParent] = sourceParent;
					++edgesInserted;
					System.out.println(edge);
				}
				
				if( edgesInserted==n-1 ) {
					break;
				}
			}
			
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		/* Let us create following weighted graph
		        10
		   0--------1
		   |  \     |
		  6|   5\   |15
		   |      \ |
		   2--------3
		       4       */
		int totalEdges = 4;
		int n= 5;
		Graph graph = new Graph(n, totalEdges);
		
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);
		
		graph.printKrustkalMST();
		
		
		
		
		
	}
}
