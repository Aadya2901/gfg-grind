class Solution {
    public int chocolatePickup(int[][] mat) {
        int n = mat.length;
        Integer[][][] dp = new Integer[n][n][n];
        int result = Math.max(0, dfs(mat, 0, 0, 0, dp));
        return result;
    }
    
    private int dfs(int[][] mat, int i1, int j1, int i2, Integer[][][] dp) {
        int n = mat.length;
        int j2 = i1 + j1 - i2;  // since i1+j1 = i2+j2
        
        // Out of bounds
        if (i1 >= n || j1 >= n || i2 >= n || j2 >= n) return Integer.MIN_VALUE;
        
        // Blocked cell
        if (mat[i1][j1] == -1 || mat[i2][j2] == -1) return Integer.MIN_VALUE;
        
        // Reached destination (bottom-right)
        if (i1 == n - 1 && j1 == n - 1) return mat[i1][j1];
        
        if (dp[i1][j1][i2] != null) return dp[i1][j1][i2];
        
        int chocolates = mat[i1][j1];
        // Avoid double-count if both robots on same cell
        if (i1 != i2 || j1 != j2)
            chocolates += mat[i2][j2];
        
        // 4 possible move combinations
        int next = Math.max(
            Math.max(dfs(mat, i1 + 1, j1, i2 + 1, dp), dfs(mat, i1, j1 + 1, i2, dp)),
            Math.max(dfs(mat, i1 + 1, j1, i2, dp), dfs(mat, i1, j1 + 1, i2 + 1, dp))
        );
        
        chocolates += next;
        
        dp[i1][j1][i2] = chocolates;
        return chocolates;
    }
}
