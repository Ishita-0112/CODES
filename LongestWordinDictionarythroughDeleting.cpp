// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        string str;
        // Traverse through dictionary vector
        for (string x: dictionary) {
            int i=0,j=0, n = x.size();
            // Check letters in x matches with letters in s
            while (i < s.size() && j < x.size()){ 
                if(s[i] == x[j])
                    j++;         
                i++;   
            }
            if (j == n && (n > str.size() || (str.size() == n && x < str)))
                str=x;    
        }
        return str; 
    }
};