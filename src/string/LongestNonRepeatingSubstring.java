package string;

import java.util.HashMap;

public class LongestNonRepeatingSubstring {
	
	public static int getLongestSubstring(String str) {
		int longestLen = 0;
		
		if( str.length()==0 ) {
			return 0;
		}
		HashMap<Character,Integer> charLastOccurence = new HashMap<Character,Integer>();
		int subStartInd=0;
		for( int curInd=0 ; curInd<str.length() ; ++curInd ) {
			char curChar = str.charAt(curInd);
			if( charLastOccurence.containsKey(curChar) ) {
				int repInd = charLastOccurence.get(curChar);
				if( repInd>=subStartInd ) {
					subStartInd = repInd+1;
				}
			}
			charLastOccurence.put(curChar, curInd);
			longestLen = Math.max(longestLen, curInd-subStartInd+1);
		}
		
		
		return longestLen;
	}
	
	public static void main(String args[]) {
		String str = "geeksforgeeks";
		System.out.println(getLongestSubstring(str));
	}
}
