// ------------------------------QUESTIONS---------------------------

// Given n non-negative integers representing an elevation map where the width of each bar is 1, 
// compute how much water it can trap after raining.

// Example 1:

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// ---------------------------SOLUTION--------------------------------

// We find the the max height of the smallest wall that bounds an area and 
// thus ca calvulate the amount of rainwater trapped in a particular vertical column accordingly

// ---------------------------CODE----------------------------------

int trap(vector<int>& height) {
        vector<int> left,right;
        int mx=0;
        for(int i=0; i<height.size(); i++){
                mx=max(mx,height[i]);
                left.push_back(mx);
        }
        mx=0;
        for(int i=height.size()-1; i>=0; i--){
                mx=max(mx,height[i]);
                right.push_back(mx);
        }
        reverse(right.begin(),right.end());
        vector<int> wall;
        for(int i=0; i<height.size(); i++){
                wall.push_back(min(left[i],right[i]));
        }
        int ans=0;
        for(int i=0; i<height.size(); i++){
                ans+=abs(wall[i]-height[i]);
        }
        return ans;
    }