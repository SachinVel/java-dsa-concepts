package other;


public class Subset {
	public static void generateSubset(int arr[]) {
		int n = arr.length;
		
		for( int i=0 ; i<n*n ; ++i ) {
			System.out.print("{ ");
			for( int j=0 ; j<n  ; ++j ) {
				if( ((1<<j)&i)==1 )
					System.out.print(arr[j]+" ");
			}
			System.out.println("}");
		}
	}
	public static void main(String[] args) {
		int arr[] = {1,2,3,4};
		generateSubset(arr);
		
	}
}
