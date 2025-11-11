class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // Step 1: Create DP table for LCS
        int[][] dp = new int[n + 1][m + 1];
        
        // Step 2: Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int lcsLength = dp[n][m];
        
        // Step 3: Apply the formula
        return n + m - lcsLength;
    }
}
