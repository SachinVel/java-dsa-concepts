package array;

import java.util.HashMap;

/*
 * Question : https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * Solution : 
 * 	1. used prefix sum with hashmap.
 *  2. calculate sum starting from first element
 *  3. if (curSum - sumNeeded) is present in prefixSum. Then it implies that from that point to now,
 *   the sum is sumNeeded. So that count is added to result.
 *  4. At first the map is initialized with (key,value)=>(0,1). The reason if the curSum is sumNeeded,
 *   then (curSum - sumNeeded) will be zero and we need to count that subarray.
 *   
 */

public class SubarraySum {

	public static int calculateNumberOfSubarrayWithKSum(int arr[], int sumNeeded) {

		int totalArrayWithKSum = 0;
		HashMap<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
		prefixSum.put(0, 1);
		int sumSoFar = 0;
		
		for (int numInd = 0; numInd < arr.length; ++numInd) {
			int curNum = arr[numInd];
			sumSoFar += curNum;
			int sumDif = sumSoFar - sumNeeded;
			if (prefixSum.containsKey(sumDif)) {
				totalArrayWithKSum += prefixSum.get(sumDif);
			}
			int curSumCount = prefixSum.getOrDefault(sumSoFar, 0);
			prefixSum.put(sumSoFar, curSumCount + 1);
		}

		return totalArrayWithKSum;

	}

	public static void main(String args[]) {
		
		int arr[] = { 1, 1, 1 };
		int sumNeeded = 2;

		System.out.println(calculateNumberOfSubarrayWithKSum(arr, sumNeeded));
	}
}
