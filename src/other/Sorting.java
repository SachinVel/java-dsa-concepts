package other;

import java.util.Arrays;

public class Sorting {
	public static void swap(int arr[],int ind1,int ind2) {
		if( ind1!=ind2 ) {
			arr[ind1] = arr[ind1]+arr[ind2];
			arr[ind2] = arr[ind1]-arr[ind2];
			arr[ind1] = arr[ind1]-arr[ind2];
		}
	}
	public static void selectionSort(int arr[]) {
		int n = arr.length;
		int minInd;
		for( int sortedInd=0 ; sortedInd<n-1 ; ++sortedInd ) {
			minInd = sortedInd;
			for( int unSortedInd=sortedInd+1 ; unSortedInd<n ; ++unSortedInd ) {
				if(arr[unSortedInd]<arr[minInd] ) {
					minInd = unSortedInd;
				}
			}
			if( minInd!=sortedInd ) {
				swap(arr, minInd, sortedInd);
			}
		}
	}
	
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		if( n==1 ) {
			return;
		}
		for( int ind1=0 ; ind1<n-1 ; ++ind1 ) {
			for( int ind2=0 ; ind2<n-ind1-1 ; ++ind2 ) {
				if( arr[ind2]>arr[ind2+1] ) {
					swap(arr, ind2, ind2+1);
				}
			}
		}
	}
	
	public static void insertionSort(int arr[]) {
		int n = arr.length;
		for( int selectInd=1 ; selectInd<n ; ++selectInd ) {
			int sortedInd=selectInd-1;
			int elem = arr[selectInd];
			while (sortedInd>=0 && arr[sortedInd]>elem) {
				arr[sortedInd+1] = arr[sortedInd];
				--sortedInd;
			}
			++sortedInd;
			arr[sortedInd] = elem;
		}
	}
	
	private static void merge(int arr[],int i1,int j1,int i2, int j2) {
		int temp[] = new int[arr.length];
		int tempInd = 0;
		int orgStartInd = i1;
		int orgEndInd = j2;
		while( i1<=j1 && i2<=j2 ) {
			if( arr[i1]<=arr[i2] ) {
				temp[tempInd] = arr[i1];
				++i1;
			}else {
				temp[tempInd] = arr[i2];
				++i2;
			}
			++tempInd;
		}
		while( i1<=j1 ) {
			temp[tempInd++] = arr[i1];
			++i1;
		}
		while( i2<=j2 ) {
			temp[tempInd++] = arr[i2];
			++i2;
		}
		for( int tempI=0,orgInd=orgStartInd ; orgInd<=orgEndInd ; ++orgInd,++tempI ) {
			arr[orgInd] = temp[tempI];
		}
	}
	
	public static void mergeSort(int arr[],int low,int high) {
		if( low<high ) {
			int mid = (low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			merge(arr, low, mid, mid+1, high);
		}
	}
	
	
	private static void heapify(int arr[],int n,int currInd) {
		int largestInd = currInd;
		int leftChildInd = 2*currInd+1;
		int rightChildInd = 2*currInd+2;
		if( leftChildInd<n && arr[leftChildInd]>arr[largestInd] ) {
			largestInd = leftChildInd;
		}
		if( rightChildInd<n && arr[rightChildInd]>arr[largestInd] ) {
			largestInd = rightChildInd;
		}
		if( largestInd!=currInd ) {
			swap(arr, largestInd, currInd);
			heapify(arr, n, largestInd);
		}
	}
	
	
	public static void heapSort(int arr[]) {
		int n = arr.length;
		for( int ind=n/2-1 ; ind>=0 ; --ind ) {
			heapify(arr, n, ind);
		}
		for( int ind=n-1 ; ind>=0 ; --ind ) {
			swap(arr, ind, 0);
			heapify(arr, ind, 0);
		}
	}
	
	private static int partition(int arr[],int low,int high) {
		int partitionElem = arr[high];
		int leftInd=low-1;
		for(int rightInd=low ; rightInd<=high-1 ; ++rightInd ) {
			if( arr[rightInd]<partitionElem ) {
				swap(arr, ++leftInd, rightInd);
			}
		}
		swap(arr, leftInd+1, high);
		return leftInd+1;
	}
	
	public static void quickSort(int arr[],int low,int high) {
		if( low<high ) {
			int partitionInd = partition(arr, low, high);
			quickSort(arr, low, partitionInd-1);
			quickSort(arr, partitionInd+1, high);
		}
	}
	
	public static void countSort(int arr[]) {
		
		//considering the given range is between 0 to 255
		int count[] = new int[256];
		int n = arr.length;
		for( int ind=0 ; ind<n ; ++ind ) {
			++count[arr[ind]];
		}
		for( int ind=1 ; ind<256 ; ++ind ) {
			count[ind] += count[ind-1];
		}
		int output[] = new int[n];
		for( int ind=0 ; ind<n ; ++ind ) {
			output[count[arr[ind]]-1] = arr[ind];
			--count[arr[ind]];
		}
		for( int ind=0 ; ind<n ; ++ind ) {
			arr[ind] = output[ind];
		}
	}
	
	
	
	
	public static void printArray(int arr[]) {
		for(int elem : arr ) {
			System.out.print(elem+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int arr[] = {1,7,5,3,2,10,9,4,8,6};
		int n = arr.length;
		String str = "asdasd";
		printArray(arr);
		countSort(arr);	
		printArray(arr);
		
	}
}
