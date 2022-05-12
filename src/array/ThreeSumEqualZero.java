package array;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* 
 *  https://leetcode.com/problems/3sum/
 */

public class ThreeSumEqualZero {
	public static List<List<Integer>> threeSum(int nums[]){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if( nums.length<3 ) {
			return result;
		}
		Arrays.parallelSort(nums);
		
		int desiredSum = 0;
		for( int firstInd=0 ; firstInd<=nums.length-3 ; ++firstInd ) {
			if( (firstInd-1)>=0 && nums[firstInd-1]==nums[firstInd] ) {
				continue;
			}
			int secondInd = firstInd+1;
			int thirdInd = nums.length-1;
			while( secondInd<thirdInd ) {
				int curTripletSum = nums[firstInd]+nums[secondInd]+nums[thirdInd];
				if( curTripletSum==desiredSum ) {
					List<Integer> triplet = new ArrayList<Integer>();
					triplet.add(nums[firstInd]);
					triplet.add(nums[secondInd]);
					triplet.add(nums[thirdInd]);
					result.add(triplet);
					++secondInd;
					while( nums[secondInd]==nums[secondInd-1] && secondInd<thirdInd) {
						++secondInd;
					}
				}else if( curTripletSum<desiredSum ) {
					++secondInd; 
				}else {
					--thirdInd;
				}
			}
			
		}
		
		return result;
	}
	public static void main(String[] args) {
		int nums[] = {-1,0,1,2,-1,-4};
		
		List<List<Integer>> result = threeSum(nums);
		System.out.println(result);
		
	}

}
