class Solution {
    public int minCutCost(int n, int[] cuts) {

        int m = cuts.length;

        // Step 1: Extend cuts array with boundaries 0 and n
        int[] c = new int[m + 2];
        c[0] = 0;
        c[m + 1] = n;
        for (int i = 0; i < m; i++) {
            c[i + 1] = cuts[i];
        }

        // Step 2: Sort the cuts
        java.util.Arrays.sort(c);

        // Step 3: Create DP table
        int[][] dp = new int[m + 2][m + 2];

        // Step 4: DP over interval length
        for (int len = 2; len < m + 2; len++) {  // interval length
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

                // try each cut between i and j
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + (c[j] - c[i]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}
