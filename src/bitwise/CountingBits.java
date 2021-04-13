package bitwise;

import java.util.Arrays;

/*
 * 
 * Given a non negative integer number num.
 * For every numbers i in the range 0 ≤ i ≤ num,
 * calculate the number of 1's in their binary representation and return them as an array.
 */

public class CountingBits {
	
	public static int[] countBits(int num) {
        int result[] = new int[num+1];
        result[0] = 0;
        int lastPow = 1;
        int leftOver=1;
        for( int curNum=1 ; curNum<=num ; ++curNum ){
            if( curNum==lastPow ){
                lastPow = lastPow<<1;
                result[curNum] = 1;
                leftOver = 1;
            }else{
                result[curNum] = 1 + result[leftOver];
                ++leftOver;
            }
        }
        return result;
        
    }
	
	public static void main(String[] args) {
		int num = 5;
		System.out.println(Arrays.toString(countBits(num)));
	}

}
