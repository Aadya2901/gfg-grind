class Solution {
    public boolean wildCard(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base Case: Empty pattern and empty text match
        dp[0][0] = true;

        // If pattern starts with '*', it can match empty string
        for (int i = 1; i <= m; i++) {
            if (pat.charAt(i - 1) == '*')
                dp[i][0] = dp[i - 1][0];
            else
                break; // stop at first non-* character
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char p = pat.charAt(i - 1);
                char t = txt.charAt(j - 1);

                if (p == t || p == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }
}
