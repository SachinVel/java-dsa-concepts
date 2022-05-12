package array;

/*
 * https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
 */
public class smallValueNotInArrSum {
	public static int findSmallest(int arr[]) {
		int res=1;
		
		for( int ind=0 ; ind<arr.length && arr[ind]<=res ; ++ind ) {
			res += arr[ind];
		}
		
		return res;
	}
	public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 5};
        int n1 = arr1.length;
        System.out.println(findSmallest(arr1));
  
        int arr2[] = {1, 2, 6, 10, 11, 15};
        int n2 = arr2.length;
        System.out.println(findSmallest(arr2));
  
        int arr3[] = {1, 1, 1, 1};
        int n3 = arr3.length;
        System.out.println(findSmallest(arr3));
  
        int arr4[] = {1, 1, 3, 4};
        int n4 = arr4.length;
        System.out.println(findSmallest(arr4));
	}
}
