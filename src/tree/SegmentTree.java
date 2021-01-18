package tree;

import java.util.Arrays;

//find sum of all ranges
public class SegmentTree {
	
	public static int constructSegmentTree(int arr[], int segTree[],int low,int high,int currInd) {
		if( low==high ) {
			segTree[currInd] = arr[low];
			return arr[low];
		}
		int mid = (high+low)/2;
		segTree[currInd] = constructSegmentTree(arr, segTree, low, mid, 2*currInd+1)+constructSegmentTree(arr, segTree, mid+1, high, 2*currInd+2);
		return segTree[currInd];
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5,6};
		int n = arr.length;
		int pow = 1;
		while( pow<n ) {
			pow *= 2;
		}
		int segTree[] = new int[2*pow-1];
		
		constructSegmentTree(arr, segTree, 0, n-1, 0);
		
		System.out.println(" segment array : "+Arrays.toString(segTree));
	}
}
