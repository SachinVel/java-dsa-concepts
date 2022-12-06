package string;

public class CountPalindromicSubsequence {
    private static int countPalindromeSubsequence(String str){

        int strLen = str.length();
        int[][] dp = new int[strLen][strLen];
        for ( int diagonalInd=0 ; diagonalInd<strLen ; ++diagonalInd ){
            dp[diagonalInd][diagonalInd] = 1;
        }

        for( int diagonalInd=1 ; diagonalInd<strLen ; ++diagonalInd ){
            for ( int startInd=0 ; startInd<(strLen-diagonalInd) ; ++startInd ){
                if( str.charAt(startInd)==str.charAt(startInd+diagonalInd) ){
                    dp[startInd][startInd+diagonalInd] = 1+dp[startInd][startInd+diagonalInd-1]+dp[startInd+1][startInd+diagonalInd];
                }else{
                    dp[startInd][startInd+diagonalInd] = dp[startInd][startInd+diagonalInd-1]+dp[startInd+1][startInd+diagonalInd]-dp[startInd+1][startInd+diagonalInd-1];
                }
            }
        }

        return dp[0][strLen-1];
    }

    public static void main(String args[]){

        String str = "aaaa";
        System.out.println(countPalindromeSubsequence(str));

    }
}
