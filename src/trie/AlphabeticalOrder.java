package trie;

public class AlphabeticalOrder {
	static String charFromIndex ="abcdefghijklmnopqrstuvwxyz";
	static Trie head;
	static final int MAX_CHAR = 26;
	static class Trie{
		boolean isEndOfWord ;
		Trie index[] = new Trie[MAX_CHAR];
		
		public Trie() {
			isEndOfWord = false;
		}
	}
	static void insertWord(String word,Trie head,int wordInd) {
		if( wordInd>=word.length() ) {
			head.isEndOfWord = true;
			return;
		}
		char currChar = word.charAt(wordInd);
		int currCharInd = currChar-'a';
		if( head.index[currCharInd]==null ) {
			head.index[currCharInd] = new Trie();
		}
		insertWord(word, head.index[currCharInd], wordInd+1);
	}
	static void preorder(Trie head,String word) {
		if(head.isEndOfWord ) {
			System.out.println(word);
		}
		for( int i=0 ; i<MAX_CHAR ; ++i ) {
			if( head.index[i]!=null ) {
				preorder(head.index[i],word+charFromIndex.charAt(i));
			}
		}
	}
	static void printInOrder(String wordArr[] ) {
		for(String word : wordArr ) {
			insertWord(word, head, 0);
		}
		preorder(head,"");
	}
	public static void main(String args[]) {
		head = new Trie();
		String input[] = {"abc","bcd","a"};
		printInOrder(input);
		
	}
}
