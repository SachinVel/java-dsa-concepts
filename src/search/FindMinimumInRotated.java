package search;

public class FindMinimumInRotated {
	
	public static int findMinimum(int arr[]) {
		
		int low = 0;
		int high = arr.length-1;
		
		while( low<=high ) {
			int mid = low+(high-low)/2;
			if( mid<arr.length-1 && arr[mid+1]<arr[mid] ) {
				return arr[mid+1];
			}else if( arr[mid]<arr[low] ) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
		return arr[0];
	}
	public static void main(String[] args) {
		int arr[] = {2, 4, 6, 7, 8, 9};
		System.out.println(findMinimum(arr));
	}
}
