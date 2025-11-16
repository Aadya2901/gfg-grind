class Solution {
    public int LCIS(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[] dp = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int currentMax = 0;  // best LCIS for values < a[i]

            for (int j = 0; j < m; j++) {

                if (a[i] > b[j]) {
                    // update best possible LCIS ending before b[j]
                    currentMax = Math.max(currentMax, dp[j]);
                }

                else if (a[i] == b[j]) {
                    // extend LCIS
                    dp[j] = currentMax + 1;
                    ans = Math.max(ans, dp[j]);
                }
            }
        }
        return ans;
    }
}
