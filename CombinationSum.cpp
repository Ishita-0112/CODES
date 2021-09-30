class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<vector<int>>> dp (target+1);
        vector<vector<int>> temp;
        vector<int> arr {};
        temp.push_back(arr);
        dp[0] = temp;
        
        for(int i=0;i<candidates.size();i++){
            for(int j=candidates[i];j<=target;j++){
                int idx = j-candidates[i];
                if(idx>=0 && dp[idx].size()){
                    for(int k=0;k<dp[idx].size();k++){
                        vector<int> v = dp[idx][k];
                        v.push_back(candidates[i]);
                        dp[j].push_back(v);
                    }
                }
            }
        }
        
        vector<vector<int>> res;
        for(int i=0;i<dp[target].size();i++)
            res.push_back(dp[target][i]);
        
        return res;
    }
};
