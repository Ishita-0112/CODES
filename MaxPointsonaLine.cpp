// https://leetcode.com/problems/max-points-on-a-line/
class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int result = 1, n = points.size();
        for(int i=0; i<n; i++) {
            // Intialize an unordered map
            unordered_map<double, int> s, x, y;
            for(int j=i+1; j<n; j++) {
				// Line parallel to y-axis
                if(points[i][1] == points[j][1]) {
                    y[points[i][1]]++;
                    result = max(result, y[points[i][1]]+1);
                } 
                // Line is parallel to x-axis
                else if(points[i][0] == points[j][0]) {
                    x[points[i][0]]++;
                    result = max(result, x[points[i][0]]+1);   
                } 
                // Check through slope of 2 points
                else {
                    double slope = double(points[i][1] - points[j][1])/(points[i][0] - points[j][0]);
                    s[slope]++;
                    result = max(result, s[slope]+1);
                }
            }
        }
        return result;
    }
};