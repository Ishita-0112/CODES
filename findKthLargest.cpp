// https://leetcode.com/problems/kth-largest-element-in-an-array/
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        // Initialize a priority queue
        priority_queue<int, vector<int>, greater<int> > pq;
        for(int i=0; i<nums.size(); i++) {
            // Add the elements to the queue
            pq.push(nums[i]);
            // Keep only k elements (largest)
            if(pq.size() > k)
                pq.pop();
        }
        return pq.top();
    }
};