package sort;

import util.ConceptUtil;

public class SelectionSort {
	
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		
		for( int curPos=0 ; curPos<n-1 ; ++curPos ) {
			int lowestElemInd = curPos;
			for( int itrInd=curPos+1 ; itrInd<n ; ++itrInd ) {
				if( arr[itrInd]< arr[lowestElemInd] ) {
					lowestElemInd = itrInd;
				}
			}
			if( lowestElemInd!=curPos ) {
				int temp = arr[lowestElemInd];
				arr[lowestElemInd] = arr[curPos];
				arr[curPos] = temp;
			}
		}
	}
	
	public static void main(String args[]) {
		
		int arr[] = { 5, 3, 4, 1, 2, 6 };
		
		ConceptUtil.print1dArray(arr);
		selectionSort(arr);
		ConceptUtil.print1dArray(arr);
		
		
		
	}
}
