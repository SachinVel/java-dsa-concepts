package search;

public class BinarySearch {
	public static void main(String[] args) {
		int arr[] = {1,2};
		int low=0,high=arr.length-1,searchElement=2;
		
		while( low<=high ) {
			int mid = low+((high-low)/2);
			if( arr[mid]==searchElement ) {
				System.out.println("found at pos "+mid);
				break;
			}else if( searchElement<arr[mid] ) {
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
	}
}
