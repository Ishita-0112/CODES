// https://leetcode.com/problems/distinct-subsequences/
class Solution {
public:
    // Recursive function
    int numDist(string &s, string &t, int m, int n, vector<vector<int>> &dp){
        if(m < 0 && n < 0 || n < 0)
            return 1; // Found
        if(m < 0)
            return 0; // Not found
        if(dp[m][n] != -1)
            return dp[m][n];
        if(s[m] != t[n])
            return dp[m][n] = numDist(s, t,m-1, n, dp); // Recursion
        
        return dp[m][n] = numDist(s, t, m-1, n-1, dp) + numDist(s, t, m-1, n, dp); // Recursion
    }
    
    int numDistinct(string s, string t) {
        // Initialize a vector to -1
        int m = s.size(), n = t.size();
        vector<vector<int>> dp(m,vector<int> (n, -1));
        
        return numDist(s, t, m-1, n-1, dp);
    }
};