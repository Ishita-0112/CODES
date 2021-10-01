// https://leetcode.com/problems/sort-colors/
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        int i, obj0 = 0, obj1 = 0;
        // Traverse through the vector
        for(i=0; i<n; i++) {
            // Swap if 0 (color - red)
            if(nums[i] == 0) {
                swap(nums[obj0 + obj1], nums[i]);
                swap(nums[obj0], nums[obj0 + obj1]);
                obj0++;
            }
            // Swap if 1 (color - blue)
            else if(nums[i] == 1) {
                swap(nums[obj0 + obj1], nums[i]);
                obj1++;
            }
        }
    }
};