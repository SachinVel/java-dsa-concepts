package util;

public class ConceptUtil {
	public static void print2dArray(int arr[][] ) {

		for( int rowInd=0 ; rowInd<arr.length ; ++rowInd ) {
			for( int colInd=0 ; colInd<arr[rowInd].length ; ++colInd ) {
				System.out.print(arr[rowInd][colInd]+" ");
			}
			System.out.println();
		}
	}
	
	public static void print1dArray(int arr[] ) {
		for( int rowInd=0 ; rowInd<arr.length ; ++rowInd ) {
			System.out.print(arr[rowInd]+" ");
		}
		System.out.println();
	}
}