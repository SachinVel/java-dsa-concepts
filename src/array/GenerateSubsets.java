package array;

public class GenerateSubsets {
	public static void printSubset(int num,char arr[]) {
		int ind=0;
		String result = "";
		while( num>0 ) {
			if( (num&1)==1 ) {
				result += arr[ind];
			}
			++ind;
			num = num>>1;
		}
		System.out.println(result);
	}
	
	public static void generateSubsets(char arr[]) {
		int arrLen = arr.length;
		int limit = (int)Math.pow(2, arrLen);
		for( int ind=0 ; ind<limit ; ++ind ) {
			printSubset(ind, arr);
		}
	}
	
	public static void main(String arg[])  
	{ 
	    char a[] = {'a','b','c','d'};
	    
	     generateSubsets(a);
	} 
}
