package array;

public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
        int curMax = nums[0], maxProduct = nums[0], curMin=nums[0];
        
        for( int ind=1 ;  ind<nums.length ;  ++ind){
            int num = nums[ind];
            int temp = curMax;
            curMax = Math.max(num, num*curMax);
            curMax = Math.max(curMax, num*curMin);
            curMin = Math.min(num, num*curMin);
            curMin = Math.min(curMin, num*temp);
            if( curMax>maxProduct ){
                maxProduct = curMax;
            }
        }
        
        return maxProduct;
    }
	public static void main(String[] args) {
		int nums[] = {2,3,-2,4};
		System.out.println(maxProduct(nums));
		
	}
}
