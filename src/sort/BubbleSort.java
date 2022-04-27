package sort;

import util.ConceptUtil;

public class BubbleSort {
	
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for( int elemAlreadySorted=0 ; elemAlreadySorted<arr.length ; ++elemAlreadySorted ) {
			for( int curElemInd=0 ; curElemInd<n-elemAlreadySorted-1 ; ++curElemInd ) {
				if( arr[curElemInd]>arr[curElemInd+1] ) {
					int temp = arr[curElemInd];
					arr[curElemInd] = arr[curElemInd+1];
					arr[curElemInd+1] = temp;
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		int arr[] = { 5, 3, 4, 1, 2, 6 };
		
		ConceptUtil.print1dArray(arr);
		bubbleSort(arr);
		ConceptUtil.print1dArray(arr);
		
		
		
	}
}
