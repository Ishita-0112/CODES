/* Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

Note:

    s could be empty and contains only lowercase letters a-z.
    p could be empty and contains only lowercase letters a-z, and characters like ? or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.

Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false

*/


class Solution {
    public boolean isMatch(String s, String p) {        
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        
       //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][writeIndex];
    }
}

