package number;

import java.util.Scanner;

public class SquareRoot {
	static double binarySearchRoot( double num , double lowBound, double highBound ) {
		System.out.println(num+" "+lowBound+" "+highBound);
		double mid = (lowBound+highBound)/2;
		double  square = mid*mid;
		if( square==num || Math.abs(num-square)<0.000001 ) {
			return mid;
		}else if( square>num ) {
			return binarySearchRoot(num, lowBound, mid);
		}else {
			return binarySearchRoot(num, mid, highBound);
		}
	}
	static double findSquareRoot( int num ) {
		float limit;
		for( limit=1 ; limit*limit<num ; ++limit );
		if( limit*limit == num ) {
			return limit;
		}
		return binarySearchRoot(num, limit-1, limit);
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.printf("%.5f",findSquareRoot(num));
		
	}
}
