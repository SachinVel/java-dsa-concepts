package number;

public class BasicNumberTheory {
	public static int findLCM(int numbers[]) {
		int max = Integer.MIN_VALUE;
		for( int num : numbers ) {
			if( num>max ) {
				max = num;
			}
		}
		boolean isFactor;
		int result=1;
		for( int factor=2 ; factor<=max ; ++factor ) {
			isFactor = false;
			for( int ind=0 ; ind<numbers.length ; ++ind ) {
				if( numbers[ind]%factor==0 ) {
					isFactor = true;
					numbers[ind] = numbers[ind]/factor;
				}
			}	
			if( isFactor ) {
				result *= factor;
			}
			for( int ind=0 ; ind<numbers.length ; ++ind ) {
				if( numbers[ind]%factor==0 ) {
					--factor;
					break;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int numbers[] = {15,25,35,45};
		System.out.println(findLCM(numbers));
	}
}
