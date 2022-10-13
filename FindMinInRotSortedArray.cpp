class Solution {
public:
    int findMin(vector<int>& arr) {
        int n = arr.size();
        int mini = INT_MAX;
        int low = 0, high = n-1;
        while(low <= high){
            long int mid = low + (high-low)/2;
            if(arr[mid] >= arr[low]){
                mini = min(mini, arr[low]);
                low = mid+1;
            }
            else{
                mini = min(mini, arr[mid]);
                high = mid-1;
            }
        }
        return mini;
    }
};
