package dynamicprogramming;

import java.math.MathContext;
import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int n=str1.length(),m=str2.length();
		int dp[][] = new int[n+1][m+1];
		for(int i=0 ; i<n ; ++i ) {
			dp[i][0]=0;
		}
		for(int i=0 ; i<m ; ++i ) {
			dp[0][i]=0;
		}
		char ch1,ch2;
		for( int i=1 ; i<=n ; ++i ) {
			ch1 = str1.charAt(i-1);
			for( int j=1 ; j<=m ; ++j ) {
				ch2 = str2.charAt(j-1);
				if( ch1==ch2 ) {
					dp[i][j] = 1+dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(" Longest Common Subsequence : "+dp[n][m]);
	}
}
