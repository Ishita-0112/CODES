/* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. */


class Solution {
    
     public int maxSub(int[] nums,int max,int index,int max_curr){
        
        if(index>nums.length-1)
            return max;
        int n = nums[index];
        max_curr = Math.max(n,n+max_curr);
        max = Math.max(max_curr,max);
        return maxSub(nums,max,index+1,max_curr);
        
        
    }
    public int maxSubArray(int[] nums) {
        
        int max = nums[0];
        int max_curr = nums[0];
        int i=0;
        return maxSub(nums,max,i=1,max_curr);
        
     
    }
}
