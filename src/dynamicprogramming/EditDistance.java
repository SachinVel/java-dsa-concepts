package dynamicprogramming;

public class EditDistance {
	public static void main(String args[]) {
		String str1="geeks",str2="gesek";
		int n1 = str1.length(), n2=str2.length();
		int dp[][] = new int[n1+1][n2+1];
		for( int ind1=0 ; ind1<n1 ; ++ind1 ) {
			dp[ind1][0] = Integer.MAX_VALUE;
		}
		for( int ind1=0 ; ind1<n2 ; ++ind1 ) {
			dp[0][ind1] = Integer.MAX_VALUE;
		}
		dp[0][0] = 0;
		int tempMin;
		for( int row=1 ; row<=n1 ; ++row ) {
			for( int col=1 ; col<=n2 ; ++col ) {
				if( str1.charAt(row-1)==str2.charAt(col-1) ) {
					dp[row][col] = dp[row-1][col-1];
				}else {
					tempMin = Math.min(dp[row-1][col], dp[row][col-1]);
					dp[row][col] = 1+Math.min(tempMin, dp[row-1][col-1]);
				}
			}
		}
		System.out.println(dp[n1][n2]);
	}

}
