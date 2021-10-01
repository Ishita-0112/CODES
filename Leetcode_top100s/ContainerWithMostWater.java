/* Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.
Note: You may not slant the container and n is at least 2. */


class Solution {
    public int maxArea(int[] height) {
        int a_pointer = 0;                          // sliding window pointer 1 in the beginning
        int b_pointer = height.length-1;            // sliding window pointer 2 at end
        int area = 0;                               // area value
        while (a_pointer<b_pointer){                //pointers moving from both ends so a should be less than b always
            int a_height = height[a_pointer];       //better not to initialize as space complexity xd
            int b_height = height[b_pointer];
            if (a_height<b_height){                                         //check for min height
                area = Math.max((a_height*(b_pointer-a_pointer)), area);    //compute area taking the min height
                a_pointer++;                                                //increment a as main motive we have to find the max such height value
            }
            else {
                area = Math.max((b_height*(b_pointer-a_pointer)), area);
                b_pointer--;
            }
        }
        return area;
    }
}
