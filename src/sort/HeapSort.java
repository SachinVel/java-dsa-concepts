package sort;

import util.ConceptUtil;

public class HeapSort {
	
	public static void heapify(int arr[],int curNodeInd, int highInd) {
		int maxElemInd = curNodeInd;
		int maxElem = arr[curNodeInd];
		
		int leftChildInd = 2*curNodeInd+1;
		if( leftChildInd<highInd && arr[leftChildInd]>maxElem ) {
			maxElem = arr[leftChildInd];
			maxElemInd = leftChildInd;
		}
		
		int rightChildInd = 2*curNodeInd+2;
		if( rightChildInd<highInd && arr[rightChildInd]>maxElem ) {
			maxElem = arr[rightChildInd];
			maxElemInd = rightChildInd;
		}
		
		if( maxElemInd!=curNodeInd ) {
			swap(arr,curNodeInd,maxElemInd);
			heapify(arr,maxElemInd,highInd);
		}
	}

	public static void swap(int arr[], int srcInd, int destInd) {
		int temp = arr[srcInd];
		arr[srcInd] = arr[destInd];
		arr[destInd] = temp;
	}
	public static void heapSort(int arr[]) {
		
		int arrLen = arr.length;
		for( int parentInd=(arrLen/2-1) ; parentInd>=0 ; --parentInd) {
			heapify(arr,parentInd,arrLen);
		}
		
		for(int ind=arrLen-1 ; ind>=0 ; --ind ) {
			swap(arr,ind,0);
			heapify(arr,0,ind);
		}
		
		
	}
	
	public static void main(String args[]) {
		
		int arr[] = {1, 4, 2, 3, 6, 5};
		
		ConceptUtil.print1dArray(arr);
	
		heapSort(arr);
		
		ConceptUtil.print1dArray(arr);
		
		
	}

}
