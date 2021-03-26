class Solution {
    public int maxDistToClosest(int[] seats) {
        int left = -1;
        int right = 0;
        int between = 1;        
        while(right < seats.length) {
            if(seats[right] == 1) {
                if(left == -1) {
                    between = right - left - 1;
                } else {
                    between = Math.max((right-left)/2, between);
                }
                left = right;
            }
            right += 1;
        }
        return Math.max(right - left - 1, between);
    }
}
