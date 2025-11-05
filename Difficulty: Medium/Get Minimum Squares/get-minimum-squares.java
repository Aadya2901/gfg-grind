class Solution {
    public int minSquares(int n) {
        // dp[i] will store the minimum number of perfect squares that sum up to i
        int[] dp = new int[n + 1];

        // Base case
        dp[0] = 0;

        // Build the dp array for all values from 1 to n
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;

            // Try every possible square less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        // The result for n will be stored in dp[n]
        return dp[n];
    }
}
