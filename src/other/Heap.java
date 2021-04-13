package other;

public class Heap {
	
	static class MinHeap{
		int maxSize;
		int size;
		int heap[];
		public MinHeap(int totalSize) {
			this.maxSize = totalSize;
			this.size = 0;
			heap = new int[maxSize+1];
		}
		public boolean isLeafNode(int pos) {
			if( pos>=(size+1)/2 ) {
				return true;
			}
			return false;
		}
		public void minHeapify(int pos) {
			
			if( !isLeafNode(pos) ) {
				if( heap[pos]>heap[2*pos] || heap[pos]>heap[pos*2+1] ) {
					
				}
			}
			
		}
		
		public int getParent(int child) {
			return child/2;
		}
		
		public void insert(int data) {
			++size;
			if( size>maxSize ) {
				return;
			}
			heap[size] = data;
			int parent = getParent(size);
			int child = size;
			while( heap[parent]>heap[child] ) {
				heap[parent] = heap[parent]+heap[child];
				heap[child] = heap[parent]-heap[child];
				heap[parent] = heap[parent]-heap[child];
				child = parent;
				parent = getParent(child);
			}
		}
		
		public int getMin() {
			return heap[1];
		}
		
		public int extractMin() {
			int min = heap[1];
			heap[1] = heap[size];
			heap[size] = 0;
			--size;
			minHeapify(1);
			return min;
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {};
	}
}
