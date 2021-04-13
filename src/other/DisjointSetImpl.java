package other;

class DisjointSet {
	int n;
	int parent[];
	int rank[];
	
	public DisjointSet( int n) {
		this.n = n;
		parent = new int[n];
		rank = new int[n];
		for( int i=0 ; i<n ; ++i ) {
			parent[i] = i;
		}
	}
	
	public int find(int node) {
		if( parent[node]==node ) {
			return node;
		}
		parent[node] = find(parent[node]) ;
		return parent[node];
	}
	public void union(int node1, int node2) {
		int parent1 = find(node1);
		int parent2 = find(node2);
		if( rank[parent1]<rank[parent2] ) {
			parent[parent1] = parent2;			
		}else if( rank[parent2]<rank[parent1] ){
			parent[parent2] = parent1;
		}else {
			parent[parent2] = parent1;
			rank[parent1] += 1;
		}
	}
	
}
public class DisjointSetImpl{
	static int findIslands( int arr[][] ) {
		
		int totalRow = arr.length;
		int totalCol ;
		if( totalRow!=0 ) {
			totalCol = arr[0].length;
		}else {
			totalCol = 0;
		}
		DisjointSet disjointSet = new DisjointSet(totalCol*totalRow);
		
		for( int row=0 ; row<totalRow ; ++row ) {
			for( int col=0 ; col<totalCol ; ++col ) {
				if( arr[row][col]==1 ) {
					if( (row-1)>=0  && arr[row-1][col]==1 ) {
						disjointSet.union((row*totalCol)+col, (row-1)*totalRow+col);
					}
					if( (row+1)<totalRow && arr[row+1][col]==1 ) {
						disjointSet.union((row*totalCol)+col, (row+1)*totalRow+col);
					}
					if( (col-1)>=0 && arr[row][col-1]==1 ) {
						disjointSet.union((row*totalCol)+col, (row)*totalRow+(col-1));
					}
					if( (col+1)<totalCol && arr[row][col+1]==1 ) {
						disjointSet.union((row*totalCol)+col, (row)*totalRow+(col+1));
					}
				}
			}	
		}
		
		int[] count = new int[totalRow*totalCol];
		int numIslands = 0;
		for( int row=0 ; row<totalRow ; ++row ) {
			for( int col=0 ; col<totalCol ; ++col ) {
				int node = row*totalRow+col;
				int parent = disjointSet.find(node);
				if( arr[row][col]==1 && count[parent]==0 ) {
					++numIslands;
					++count[parent];
				}
			}
		}
		
		return numIslands;
	}
	
	public static void main(String[] args) {
		int[][] a = new int[][] {
			{1, 1, 0, 0, 0}, 
            {0, 1, 0, 0, 1}, 
            {1, 0, 0, 1, 1}, 
            {0, 0, 0, 0, 0}, 
            {1, 0, 1, 0, 1} 
        };
        System.out.println(findIslands(a));
	}
}
