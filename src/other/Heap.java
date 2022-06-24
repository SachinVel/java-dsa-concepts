package other;

import java.util.Arrays;

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
		
		private void swap(int pos1, int pos2) {
			int temp = heap[pos1];
			heap[pos1] = heap[pos2];
			heap[pos2] = temp;
		}
		public void minHeapify(int pos) {
			
			if( !isLeafNode(pos) ) {
				int leftChild = getLeftChild(pos);
				int rightChild = getRightChild(pos);
				if( heap[pos]>heap[leftChild] || heap[pos]>heap[rightChild] ) {
					if( heap[leftChild]<heap[rightChild] ) {
						swap(pos,leftChild);
						pos = leftChild;
					}else {
						swap(pos,rightChild);
						pos = rightChild;
					}
					minHeapify(pos);
				}
			}
			
		}
		
		private int getLeftChild(int pos) {
			return 2*pos;
		}
		
		private int getRightChild(int pos) {
			return 2*pos+1;
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
		
		public void printHeap() {
			System.out.println(Arrays.toString(heap));
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,4,5,7,3,9,10};
		
		MinHeap minHeap = new MinHeap(arr.length);
		for( int num : arr ) {
			minHeap.insert(num);
		}
		
		minHeap.printHeap();
		
		System.out.println(minHeap.extractMin());
		
		minHeap.printHeap();
		
		System.out.println(minHeap.extractMin());
	}
}
