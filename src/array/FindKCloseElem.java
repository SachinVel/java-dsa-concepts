package array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
 */

public class FindKCloseElem {

	class FastReader {
		private StringTokenizer st;
		private BufferedReader br;

		FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreElements()) {
				st = new StringTokenizer(br.readLine());
			}
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public static List<Integer> getKClosestElem(int arr[], int k, int x) {
		List<Integer> result = new ArrayList<Integer>();
		if (k == 0 || arr.length == 0 || arr.length < k) {
			return result;
		}
		if (arr.length == 1) {
			result.add(arr[0]);
			return result;
		}

		// binary search
		int low = 0, high = arr.length - 1;
		int leftRange = 0, rightRange = arr.length-1;
		boolean isXLow = false, isXHigh = false;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if( x<=arr[low] ) {
				leftRange=low-1;
				rightRange = low;
				break;
			}else if( x>=arr[high] ) {
				leftRange = high;
				rightRange = high+1;
				break;
			}else{
				if( arr[mid]<=x && arr[mid+1]>x ) {
					leftRange = mid;
					rightRange=mid+1;
					break;
				}else if( x<arr[mid] ) {
					high = mid-1;
				}else {
					low = mid+1;
				}
			}
		}
		System.out.println("insert Pos : "+leftRange+" "+rightRange);
		while (k > 0) {
			if (leftRange < 0) {
				result.add(arr[rightRange]);
				++rightRange;
			} else if (rightRange >= arr.length) {
				result.add(arr[leftRange]);
				--leftRange;
			} else {
				int leftDif = Math.abs(x - arr[leftRange]);
				int rightDif = Math.abs(x - arr[rightRange]);
				if (leftDif < rightDif) {
					result.add(arr[leftRange]);
					--leftRange;
				} else {
					result.add(arr[rightRange]);
					++rightRange;
				}
			}
			--k;
		}

		return result;
	}

	public static void main(String args[]) {
		int arr[] = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int k = 4, x = 35;

		List<Integer> kCloseElem = getKClosestElem(arr, k, x);

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		System.out.println(kCloseElem.toString());

	}

}
