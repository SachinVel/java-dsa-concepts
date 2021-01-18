package other;

public class RabinKarpPatternSearching {
	static final int p = 256,q=150;
	static boolean checkSubstring(String text,String pattern, int lastInd) {
		int m = pattern.length();
		for(int patternInd=0,textInd=lastInd-m+1 ; textInd<lastInd ; ++patternInd,++textInd ) {
			if( text.charAt(textInd)!=pattern.charAt(patternInd) ) {
				return false;
			}
		}
		return true;
	}
	static void searchPattern(String text,String pattern) {
		int h=1;
		int n = text.length();
		int m = pattern.length();
		int patternHash=0,textHash=0;
		
		for(int itr=0 ; itr<m-1 ; ++itr ) {
			h = (h*p)%q;
		}
		for(int ind=0 ; ind<m ; ++ind ) {
			patternHash = (patternHash*p+pattern.charAt(ind))%q;
			textHash = (textHash*p+text.charAt(ind))%q;
		}
		if( textHash==patternHash ) {
			if( checkSubstring(text, pattern,m-1)) {
				System.out.println("Pattern found at index 0");
			}
		}
		for( int ind=m ; ind<n ; ++ind ) {
			textHash = (p*(textHash-h*text.charAt(ind-m))+text.charAt(ind))%q;
			if (textHash < 0) 
				textHash = (textHash + q); 
			
			if( textHash==patternHash ) {
				if( checkSubstring(text, pattern, ind)) {
					System.out.println("Pattern found at index "+(ind-m+1));
				}
			}
		}
	}
	public static void main(String[] args) {
		String text="THIS IS A TEST TEXT",pattern="TEXT";
		searchPattern(text, pattern);
	}
}	
