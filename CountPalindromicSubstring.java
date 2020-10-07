class Solution {
    public int countSubstrings(String s) {
        if (s.isEmpty()) {
        return 0;
    }
    int n = s.length();
    // dp[i][j] will be false if substring str[i..j]
    // is not palindrome. Else, dp[i][j] will be true
    boolean[][] dp = new boolean[n][n];

    int count = 0;

    // All substrings of length 1 are palindromes
    for (int i = 0; i < n; i++) {
        dp[i][i] = true;
        count++;
    }

    int i, ls, j;

    // check for sub-string of length 2
    for (i = 0; i < n - 1; i++) {
        if (s.charAt(i) == s.charAt(i + 1)) {
            dp[i][i + 1] = true;
            count++;
        }
    }

    // Check for lengths greater than 2
    // ls is length of substring
    for (ls = 3; ls <= n; ls++) {
        // i is the starting index
        for (i = 0; i < n - ls + 1; i++) {
            // j is ending index of substring from starting index i and length ls
            j = i + ls - 1;
            // checking for sub-string from ith index to
            // jth index iff str.charAt(i+1) to
            // str.charAt(j-1) is a palindrome
            if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                dp[i][j] = true;
                count++;
            }
        }
    }

    return count;
    }
}
