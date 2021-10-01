// -------------------------QUESTION---------------------------------

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

// ---------------------------SOLUTION-----------------------------------

// We can make use of min heap and max heap for this problem to acieve the required time complexity

// --------------------------CODE---------------------------------

double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2){
    priority_queue<int> low; // max-heap -> returns the max of the smaller half
    priority_queue<int, vector<int>, greater<int>> high; // min-heap -> returns the min of the larger part
    for(int i=0; i<nums1.size(); i++){
        low.push(nums1[i]);
        hight.push(low.top());
        low.pop();
        if(low.size()<high.size()){
            low.push(high.top());
            high.pop();
        }
    }
    for(int i=0; i<nums2.size(); i++){
        low.push(nums2[i]);
        high.push(low.top());
        low.pop();
        if(low.size()<high.size()){
            low.push(high.top());
            high.pop();
        }
    }
    double res;
    if(low.size()>high.size()){
        res=(double)low.top();
    }
    else{
        res=(double)((low.top()+high.top())/2);
    }
    return res;
}