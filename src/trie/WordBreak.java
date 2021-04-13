package trie;

import java.util.Scanner;

public class WordBreak {
	static final int MAX_CHARACTERS = 26;
	static class TrieNode{
		boolean isEndOfWord;
		TrieNode index[];
		public TrieNode() {
			index = new TrieNode[MAX_CHARACTERS];
			for( int i=0 ; i<MAX_CHARACTERS ; ++i ) {
				index[i] = null;
			}
			isEndOfWord = false;
		}
	}
	static TrieNode insertWord(String word,TrieNode head) {
		
		int wordLen = word.length();
		TrieNode itrNode = head;
		int ind = 0;
		while( ind<wordLen ) {
			int curCharInd = word.charAt(ind)-'a';
			if( itrNode.index[curCharInd]==null ) {
				itrNode.index[curCharInd] = new TrieNode();
			}
			itrNode = itrNode.index[curCharInd];
			++ind;
		}
		itrNode.isEndOfWord = true;
		return head;
		
	}
	
	static void prefix( TrieNode head ,String currString) {
		if( head.isEndOfWord ) {
			System.out.println(currString);
		}
		for( int itr=0 ; itr<MAX_CHARACTERS ; ++itr ) {
			if( head.index[itr]!=null ) {
				char curChar = (char)('a'+itr);
				prefix(head.index[itr], currString+curChar);
			}
		}
	}
	
	static boolean isInputBreakable(String word,int curInd,TrieNode head,TrieNode curNode) {
		if(curInd>=word.length()) {
			if( curNode.isEndOfWord ) {
				return true;
			}else {
				return false;
			}
		}
		boolean result = false;
		int curCharInd = word.charAt(curInd)-'a';
		if( curNode.index[curCharInd]!=null ) {
			if( curNode.index[curCharInd].isEndOfWord ) {
				result = result || isInputBreakable(word, curInd+1, head,head);
			}
			result = result || isInputBreakable(word, curInd+1, head,curNode.index[curCharInd]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		String dictionary[] = {"mobile","samsung","sam", 
                    "sung","man","mango", 
                    "icecream","and","go","i", 
                    "like","ice","cream"
                    };
		
		TrieNode head = new TrieNode();
		for(String word : dictionary ) {
			head = insertWord(word,head);
		}
//		prefix(head,"");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next(); 
		System.out.println("Is word "+input+" breakable? "+isInputBreakable(input,0,head,head));
		
		
	}
}
