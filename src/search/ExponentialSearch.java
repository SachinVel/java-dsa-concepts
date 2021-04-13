package search;

public class ExponentialSearch {
	public static int exponentialSearch(int arr[], int searchVal) {
		int resultInd=-1;
		int pow = 1;
		int n = arr.length;
		
		if( arr[0]==searchVal ) {
			return 0;
		}
		while( pow<n && arr[pow]<=searchVal ) {
			pow *= 2;
		}
		
		//after finding the range using exponential search : binary search
		int low = pow/2;
		int high = Math.min(pow, n-1);
		while( low<=high ) {
			int mid = (low+high)/2;
			if( arr[mid]==searchVal ) {
				return mid;
			}else if( searchVal<arr[mid] ) {
				high = mid-1;
			}else{
				low = mid+1;
			}
		}
		return resultInd;
	}
	public static void main(String[] args) {
		int arr[] = {1,4,6,10,12,15,16,19,22,25,28,30,32,35,42,50,52,55,57,64};
		int searchVal = 30;
		System.out.println(exponentialSearch(arr, searchVal));

	}
}
