package dynamicprogramming;

import util.ConceptUtil;

public class SubsetSum {
	public static boolean findSubsetSum(int arr[],int sum ) {
		int n = arr.length;
		int dp[][] = new int[n+1][sum+1];

		for( int ind=0 ; ind<=n ; ++ind ) {
			dp[ind][0] = 1;
		}
		
		for( int row=1 ; row<=n ; ++row ) {
			for( int col=1 ; col<=sum ; ++col ) {
				dp[row][col] = dp[row-1][col];
				if( col-arr[row-1]>=0 && dp[row-1][col-arr[row-1]]==1 ) {
					dp[row][col] = 1;
				}
				
			}
		}
		ConceptUtil.print2dArray(dp);
		
		if( dp[n][sum]>0 ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		
		int arr[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		
		System.out.println(findSubsetSum(arr, sum));
	}
}
