package dynamicprogramming;

public class LargestPalindromicSubsequence {
	
	public static int findPalindromicSubsequence(String str) {
		int n = str.length();
		int dp[][] = new int[n][n];
		
		//prefill values
		for( int row=0 ; row<n ; ++row ) {
			dp[row][row] = 1;
		}
		int row,col;
		for( int diagonal=1 ; diagonal<n ; ++diagonal ) {
			for( int ind2=0 ; (ind2+diagonal)<n ; ++ind2 ) {
				row = ind2;
				col = ind2+diagonal;
				if( str.charAt(row)==str.charAt(col) ) {
					if( col-row>0 ) {
						dp[row][col] = 2+dp[row+1][col-1];
					}else {
						dp[row][col] = 2;
					}
				}else {
					dp[row][col] = Math.max(dp[row][col-1], dp[row+1][col]);
				}
			}
		}
		printdp(dp);
		return dp[0][n-1];
	}
	
	public static void printdp(int arr[][]) {
		int n = arr.length;
		for( int row=0 ; row<n ; ++row ) {
			for( int col=0 ; col<n ; ++col ) {
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(findPalindromicSubsequence(str));
	}
}
