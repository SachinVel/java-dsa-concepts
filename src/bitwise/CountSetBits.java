package bitwise;

public class CountSetBits {
	
	public static int countSetBits( int num ) {
		int setBits = 0;
		
		while( num>0 ) {
			num = num&(num-1);
			++setBits;
		}
		if( num<0 ){
			for( int ind=1 ; ind<=32 ; ++ind ) {
				setBits += (num&1);
				num = num>>1;
			}
		}
		return setBits;
	}
	public static void main(String[] args) {
		int n = -3;
		
		System.out.println(countSetBits(n));
		
	}
}
