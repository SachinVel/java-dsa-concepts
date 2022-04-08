package array;

import util.ConceptUtil;

/*
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 */

public class MergeTwoSortedArray {
	public static void sortTwoArrays(int arr1[], int arr2[]) {
		int ptr1 = 0, ptr2 = 0;

		if (arr1.length == 0 || arr2.length == 0) {
			return;
		}

		while (ptr1 < arr1.length) {
			if (arr1[ptr1] <= arr2[0]) {
				++ptr1;
			} else {
				int temp = arr1[ptr1];
				arr1[ptr1] = arr2[0];
				ptr2 = 0;
				while (ptr2 + 1 < arr2.length && arr2[ptr2 + 1] < temp) {
					arr2[ptr2] = arr2[ptr2 + 1];
					++ptr2;
				}
				arr2[ptr2] = temp;
				++ptr1;
			}
		}

	}

	public static void main(String[] args) {
		int arr1[] = { 1, 5, 9, 10, 15, 20 };
		int arr2[] = { 2, 3, 8, 13 };

		sortTwoArrays(arr1, arr2);

		ConceptUtil.print1dArray(arr1);
		ConceptUtil.print1dArray(arr2);

	}
}
