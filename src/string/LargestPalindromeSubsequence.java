package string;


/*
    Question : https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

    Recursive Approach :
       1. The recursive approach is
            a. If characters at both end matches => then LP(0,n-1) becomes 2+LP(1,n-2)
            b. If characters at both end doesn't match => then LP(0,n-1) becomes Max(LP(0,n-2),LP(1,n-1))
       2. Since this recursive approach has overlapping problems, DP approach is used where  values are stored in
          2D array and referred.
       3. By this way, The time complexity is reduced from exponential to quadratic time.

     Note :
        1. For getting largest palindromic substring, DP is not required. Only for largest palindromic subsequence DP is needed.

 */

public class LargestPalindromeSubsequence {

    private static int getLargestPalindromeSubsequence(String str){

        int strLen = str.length();
        int[][] dp = new int[strLen][strLen];
        for ( int diagonalInd=0 ; diagonalInd<strLen ; ++diagonalInd ){
            dp[diagonalInd][diagonalInd] = 1;
        }

        for( int diagonalInd=1 ; diagonalInd<strLen ; ++diagonalInd ){
            for ( int startInd=0 ; startInd<(strLen-diagonalInd) ; ++startInd ){
                if( str.charAt(startInd)==str.charAt(startInd+diagonalInd) ){
                    dp[startInd][startInd+diagonalInd] = 2+dp[startInd+1][startInd+diagonalInd-1];
                }else{
                    dp[startInd][startInd+diagonalInd] = Math.max(dp[startInd][startInd+diagonalInd-1],dp[startInd+1][startInd+diagonalInd]);
                }
            }
        }

        return dp[0][strLen-1];
    }

    public static void main(String args[]){

        String str = "geeksforgeeks";
        System.out.println(getLargestPalindromeSubsequence(str));

    }
}
