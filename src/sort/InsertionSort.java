package sort;

import util.ConceptUtil;

public class InsertionSort {
	
	public static void insertionSort(int arr[]) {
		
		int n = arr.length;
		for( int curElemInd=1 ; curElemInd<n ; curElemInd++ ) {
			int itrInd=curElemInd-1;
			int curElem = arr[curElemInd];
			while( itrInd>=0 && curElem<arr[itrInd] ) {
				arr[itrInd+1]=arr[itrInd];
				--itrInd;
			}
			arr[itrInd+1] = curElem;
		}
		
	}
	public static void main(String args[]) {
		
		int arr[] = { 5, 3, 4, 1, 2, 6 };
		
		ConceptUtil.print1dArray(arr);
		insertionSort(arr);
		ConceptUtil.print1dArray(arr);
		
		
		
	}

}
