package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * Chef Monocarp has just put 𝑛 dishes into an oven. He knows that the 𝑖-th dish has its optimal cooking time equal to 𝑡𝑖 minutes.

At any positive integer minute 𝑇
 Monocarp can put no more than one dish out of the oven. If the 𝑖-th dish is put out at some minute 𝑇, 
 then its unpleasant value is |𝑇−𝑡𝑖| — the absolute difference between 𝑇 and 𝑡𝑖
.Once the dish is out of the oven, it can't go back in.


Key points in this problem
1) here dp[i][j] - tells the minimum unplesant time considering i dishes and in J time
2) if dishes are sorted it means that there is an optimal answer such that the times 𝑇
 for each dish go in the increasing order
 			That's not too hard to prove (something along the lines of if there are two dishes 𝑖 and 𝑗 such that 𝑡𝑖<𝑡𝑗 and 𝑇𝑖>𝑇𝑗 ,
 			 then |𝑡𝑖−𝑇𝑖|+|𝑡𝑗−𝑇𝑗| is always greater than |𝑡𝑖−𝑇𝑗|+|𝑡𝑗−𝑇𝑖|
).
 */
public class OvenAndDishes {
	public static void print2DArray(int arr[][]) {
		int rowLen = arr.length;
		int colLen = arr[0].length;
		for( int rowInd=0 ; rowInd<rowLen ; ++rowInd ) {
			for( int colInd=0 ; colInd<colLen ; ++colInd ) {
				System.out.print(arr[rowInd][colInd]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dishes[] = new int[n];
		for( int ind=0 ; ind<n ; ++ind ) {
			dishes[ind] = sc.nextInt();
		}
		int maxVal = (int)Integer.MAX_VALUE;
		int dp[][] = new int[n+1][2*n];
		for( int[] arr : dp ) {
			Arrays.fill(arr, maxVal);	
		}
		dp[0][0] = 0;
		Arrays.sort(dishes);
		System.out.println();
		for(int rowInd=0 ; rowInd<=n ; ++rowInd ) {
			for( int colInd=0 ; colInd<(2*n-1) ; ++colInd ) {
				if( dp[rowInd][colInd]<maxVal ) {
					if( rowInd<n ) {
						dp[rowInd+1][colInd+1] = Math.min(dp[rowInd+1][colInd+1],dp[rowInd][colInd]+Math.abs(colInd-dishes[rowInd]));
					}
					dp[rowInd][colInd+1] = Math.min(dp[rowInd][colInd+1],dp[rowInd][colInd]);
				}
			}
		}
		System.out.println("dishes array : "+Arrays.toString(dishes));
		print2DArray(dp);
		System.out.println(dp[n][2*n-1]);
		
		
	}
	
}
