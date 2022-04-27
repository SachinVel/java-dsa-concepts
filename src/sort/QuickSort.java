package sort;

import util.ConceptUtil;

public class QuickSort {

	public static int partition(int arr[], int low, int high ) {
		int midElem = arr[high];
		int i=low;
		
		for( int j=low ; j<=(high-1) ; ++j ) {
			if( arr[j]<midElem ) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				++i;
			}
		}
		
		int temp = arr[i];
		arr[i] = arr[high];
		arr[high] = temp;
		
		return i;
	}
	
	public static void quickSort(int arr[],int low, int high) {
		if( low<high ) {
			int midInd = partition(arr,low,high);
			quickSort(arr,low,midInd-1);
			quickSort(arr,midInd+1,high);
		}
	}
	public static void main(String args[]) {
		int arr[] = {1,5,3,2,4,6};
		
		ConceptUtil.print1dArray(arr);
		
		quickSort(arr,0,arr.length-1);
		
		ConceptUtil.print1dArray(arr);
		
		
	}
}
