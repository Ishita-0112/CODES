bool wordBreak(string s, vector<string>& wordDict) {
        set<string> dict(wordDict.begin(), wordDict.end());
        vector<int> dp(s.length(), -1);
        return f(0, s, dict, dp);
    }
	
	bool f(int ind, string &s, set<string> &dict, vector<int>& dp) {
        if(ind == s.length()) return true;
        if(dp[ind] != -1) return dp[ind];
        
        for(int i = ind; i < s.length(); i++) {
            string cur = s.substr(ind, i-ind+1);
            if(dict.find(cur) != dict.end() && f(i+1, s, dict, dp)) {
                return dp[ind] = true;
            }
        }
        return dp[ind] = false;
    }
