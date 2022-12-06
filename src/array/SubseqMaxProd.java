package array;

import java.util.Arrays;

/*
 * Given an array A[] of n integers, the task is to find a subsequence of size k whose product is maximum among all possible k sized subsequences of the given array.

Input : A[] = {1, 2, 0, 3}, 
          k = 2
Output : 6 (2*3)

 */

public class SubseqMaxProd {
	
	public static int findSubsequenceProduct(int arr[],int k) {

		int product=1;
		int n =arr.length;
		if( k>n ) {
			return -1;
		}
		if( k==n ) {
			for( int num : arr) {
				product *= num;
			}
			return product;
		}
		Arrays.sort(arr);
		int maxElem = arr[n-1];
		int startPtr=0,endPtr=n-1;
		
		if( k%2!=0 ) {
			if( maxElem >0 ) {
				product *= arr[endPtr];
				--k;
			}else if( maxElem==0 ) {
				return 0;
			}else {
				for(int ind=n-1 ; ind>=n-k ; --ind ) {
					product *= arr[ind];
				}
				return product;
			}
		}
		
		for( int ind=0 ; ind<k/2 ; ++ind ) {
			if( arr[startPtr]*arr[startPtr+1]>arr[endPtr]*arr[endPtr-1] ) {
				product *= arr[startPtr]*arr[startPtr+1];
				startPtr += 2;
			}else {
				product *= arr[endPtr]*arr[endPtr-1];
				endPtr -= 2;
			}
		}
		
		return product;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,2,0,3};
		int k = 2;
		
		System.out.println(findSubsequenceProduct(arr, k));
		
	}

}
