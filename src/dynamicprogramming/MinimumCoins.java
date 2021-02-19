package dynamicprogramming;

import java.util.Arrays;

import util.ConceptUtil;

/*
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 */

public class MinimumCoins {
	
	public static int findMinimumCoins(int coins[], int sum ) {
		int n = coins.length;
		int dp[][] = new int[n+1][sum+1];
		Arrays.sort(coins);
		for( int row=0 ; row<=n ; ++row ) {
			for( int col=1 ; col<=sum ; ++col ) {
				dp[row][col] = Integer.MAX_VALUE;
			}
		}
		for( int ind=1 ; ind<=n ; ++ind ) {
			if( coins[ind-1]>sum ) {
				continue;
			}
			for( int curSum=1 ; curSum<=sum ; ++curSum ) {
				if( curSum-coins[ind-1]>=0 && dp[ind-1][curSum-coins[ind-1]]!=Integer.MAX_VALUE) {
					dp[ind][curSum] = Math.min(dp[ind-1][curSum], 1+dp[ind-1][curSum-coins[ind-1]]);
				}else {
					if( dp[ind-1][curSum]!=Integer.MAX_VALUE ) {
						dp[ind][curSum] = dp[ind-1][curSum];
					}
				}
			}
		}
		ConceptUtil.print2dArray(dp);
		return dp[n][sum];
	}
	public static void main(String[] args) {
		int coins[] = {9, 6, 5, 1,1};
		int sum = 12;
		System.out.println(findMinimumCoins(coins, sum));
	}
	
}
