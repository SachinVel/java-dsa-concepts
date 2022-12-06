package string;

/*
    Question : Print all palindrome permutation of a string
    Resource : https://www.geeksforgeeks.org/print-all-palindrome-permutations-of-a-string/
    Approach :
 */
public class PrintAllPalindromePermutation {
    public static boolean checkPalindrome(String str){
        int bitVector = 0;
        for( char chr : str.toCharArray() ){
            int chrNum = chr-'a';
            int chrBit = 1<<chrNum;
            bitVector ^= chrBit;
        }

        int oneCount = 0;
        while( bitVector!=0 ){
            if( (bitVector&1)==1 ){
                ++oneCount;
            }
            bitVector >>= 1;
        }
        return oneCount<=1;
    }

    public static void printAllPermutation( String str, int l, int r ){

        if (l == r){
            System.out.println(str);
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                printAllPermutation(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    public static String swap( String str, int srcInd, int destInd ){
        char[] strArr = str.toCharArray();
        char temp = strArr[srcInd];
        strArr[srcInd] = strArr[destInd];
        strArr[destInd] = temp;
        return String.valueOf(strArr);
    }
    public static void main(String args[]){
        String str = "abc";
        if( checkPalindrome(str) ){
            printAllPermutation(str,0,str.length()-1);
        }

    }
}
