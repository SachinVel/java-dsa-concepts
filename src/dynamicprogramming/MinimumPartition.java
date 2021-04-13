package dynamicprogramming;

import java.util.Arrays;

import util.ConceptUtil;

public class MinimumPartition {
	private static int findMinPartition(int arr[]) {
		int sum=0, n=arr.length,minResult = arr[0];
		
		Arrays.sort(arr);
		minResult = arr[arr.length-1];
		for( int ind=0 ; ind<arr.length ; ++ind ) {
			sum += arr[ind];
		}
		
		ConceptUtil.print1dArray(arr);
		
		int dp[][] = new int[n+1][sum+1];
		for( int rowInd=0; rowInd<=n ; ++rowInd ) {
			dp[rowInd][0] = 1;
		}
		for( int rowInd=1; rowInd<=n ; ++rowInd ) {
			int startColInd = 1;
			int curElem = arr[rowInd-1];
			while( startColInd<=sum ) {
				if( ( startColInd-curElem>=0 && dp[rowInd-1][startColInd-curElem]==1) || dp[rowInd-1][startColInd]==1 ) {
					dp[rowInd][startColInd] = 1;
				}
				++startColInd;
			}
		}
		
		for( int colInd = sum/2 ; colInd>=0 ; --colInd ) {
			if( dp[n][colInd]==1 ) {
				if( (sum-2*colInd)<minResult ) {
					minResult = sum-2*colInd;
				}
			}
		}
		ConceptUtil.print2dArray(dp);
				
		return minResult;
	}
	public static void main(String[] args) {
		int arr[] = {3, 1, 4, 2, 2, 1};
		System.out.println(findMinPartition(arr));
	}
}
