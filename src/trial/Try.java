package trial;

import java.util.Arrays;

public class Try {
	
	public static int binarySearch( int arr[], int searchElem ) {
		int low=0, high=arr.length-1;
		
		while( low<=high ) {
			int mid = low+(high-low)/2;
			if( arr[mid]==searchElem ) {
				return mid;
			}else if( searchElem>arr[mid] ){
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 5, 7, 9, 11};
		
		System.out.println(binarySearch(arr,9));
		
	}
}
