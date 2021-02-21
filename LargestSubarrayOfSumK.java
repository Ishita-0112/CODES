class Solution {
    public int subarraySum(int[] nums, int k) {
        int i=0; int j=0; int sum= 0; int count = 0;
        int mx = INT_MIN;
        while (j<nums.length){
            sum+=nums[j];
            if(sum<k){
                j++;
            }
            else if (sum==k){
                mx = Math.max(mx, j - i + 1);;
                j++;
            }
            else if (sum>k){
                while (sum>k){
                    sum=sum-nums[i];
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}
