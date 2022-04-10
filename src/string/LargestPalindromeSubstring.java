package string;


/* 
 * question - https://leetcode.com/problems/longest-palindromic-substring 
 * 
 */
 
class LargestPalindromeSubstring {
	
	public static int getEvenPalidrome(String str, int curInd) {
		int len = 1;
		int lowInd = curInd,highInd = curInd+1; 
		
		while(lowInd>=0 && highInd<str.length() ) {
			if( str.charAt(lowInd)!=str.charAt(highInd) ) {
				break;
			}
			len = highInd-lowInd+1;
			--lowInd;
			++highInd;
		}
		return len;
	}
	
	public static int getOddPalindrome(String str, int curInd) {
		int len = 1;
		int lowInd = curInd-1,highInd = curInd+1; 
		
		while(lowInd>=0 && highInd<str.length() ) {
			if( str.charAt(lowInd)!=str.charAt(highInd) ) {
				break;
			}
			len = highInd-lowInd+1;
			--lowInd;
			++highInd;
		}
		return len;
	}
	
	public static String largestPalindrome(String str) {
		String result=null;
		int maxLen = -1;
		for(int ind=0 ; ind<str.length() ; ++ind ) {
			int evenLen = getEvenPalidrome(str, ind);
			int oddLen = getOddPalindrome(str, ind);
			if( evenLen>maxLen ) {
				maxLen = evenLen;
				int lowInd = ind-evenLen/2+1;
				int highInd = ind+evenLen/2;
				result = str.substring(lowInd,highInd+1);
			}
			if( oddLen>maxLen ) {
				maxLen = oddLen;
				int lowInd = ind-oddLen/2;
				int highInd = ind+oddLen/2;
				result = str.substring(lowInd,highInd+1);
			}
		}
		
		return result;
		
	}
	public static void main(String args[]) {
		String str = "abacab";
		
		System.out.println(largestPalindrome(str));
		
	}

}
