package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSumEqualZero {
	public static List<List<Integer>> threeSum(int nums[]){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if( nums.length<3 ) {
			return result;
		}
		Arrays.parallelSort(nums);
		HashMap<Integer,List<List<Integer>>> twoNumSums = new HashMap<Integer, List<List<Integer>>>();
		
		for( int ind1=0; ind1<nums.length-1 ; ++ind1 ) {
			for( int ind2=ind1+1 ; ind2<nums.length ; ++ind2 ) {
				List<Integer> pairs = new ArrayList<Integer>();
				pairs.add(ind1);
				pairs.add(ind2);
				int pairSum = nums[ind1]+nums[ind2];
				List<List<Integer>> pairList = twoNumSums.get(pairSum);
				if( pairList==null ) {
					pairList = new ArrayList<List<Integer>>();
					pairList.add(pairs);
					twoNumSums.put(pairSum,pairList);
				}else {
					pairList.add(pairs);
				}
			}
		}
		HashSet<Integer> hashValues = new HashSet<Integer>();
		
		for( int ind=0 ; ind<nums.length ; ++ind ) {
			int compNum = -nums[ind];
			if( twoNumSums.get(compNum)!=null ) {
				for( List<Integer> pairs : twoNumSums.get(compNum) ) {
					if( ind!=pairs.get(0) && ind!=pairs.get(1) && ind>pairs.get(0) && ind>pairs.get(1) ) {
						int hashValue = nums[ind]*1+nums[pairs.get(0)]*2+nums[pairs.get(1)]*3;
						if( !hashValues.contains(hashValue)  ) {
							List<Integer> triplets = new ArrayList<Integer>();
							triplets.add(nums[ind]);
							triplets.add(nums[pairs.get(0)]);
							triplets.add(nums[pairs.get(1)]);
							result.add(triplets);
							hashValues.add(hashValue);
						}
						
					}
					
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
