package bitwise;

import java.util.Scanner;

//This program implements power function in O(logn) complexity

public class PowerFn {
	static int powerFunction( int num, int power ) {
		int result=1;
		int temp=num;
		while( power>0 ) {
			if( (power&1)==1 ) {
				result *= temp;
			}
			temp *= temp;
			power = power>>1;
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int power = sc.nextInt();
		System.out.println(powerFunction(num, power)); 
	}
}
