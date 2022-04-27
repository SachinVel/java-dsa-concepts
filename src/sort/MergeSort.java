package sort;

import util.ConceptUtil;

public class MergeSort {

	public static void merge(int arr[], int i1, int i2, int j1, int j2) {
		int i = i1, j = j1, k=0;
		int temp[] = new int[100];
		while( i<=i2 && j<=j2 ) {
			if( arr[i]<arr[j] ) {
				temp[k++] = arr[i++];
			}else {
				temp[k++] = arr[j++];
			}
		}
		
		while( i<=i2 ) {
			temp[k++] = arr[i++];
		}
		
		while( j<=j2 ) {
			temp[k++] = arr[j++];
		}
		
		for( int ind1=0,ind2=i1 ; ind2<=j2 ; ++ind1,++ind2 ) {
			arr[ind2] = temp[ind1];
		}
			
	}
	public static void mergeSort(int arr[], int low, int high) {
		if(low<high) {
			int mid = low+(high-low)/2;
			mergeSort(arr,low,mid);
			mergeSort(arr,mid+1,high);
			merge(arr,low,mid,mid+1,high);
		}
	}
	public static void main(String args[]) {
		int arr[] = {1,4,5,2,7,3,6};
		
		ConceptUtil.print1dArray(arr);
		
		mergeSort(arr,0,arr.length-1);
		
		ConceptUtil.print1dArray(arr);
		
	}
}
