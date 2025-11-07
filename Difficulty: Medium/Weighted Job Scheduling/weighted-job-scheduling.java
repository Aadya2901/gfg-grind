import java.util.*;

class Solution {
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        
        // Step 1: Sort jobs by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        // Step 2: Create DP array
        int[] dp = new int[n];
        dp[0] = jobs[0][2]; // profit of first job
        
        // Step 3: Process each job
        for (int i = 1; i < n; i++) {
            int profit = jobs[i][2];
            
            // Step 4: Find last non-overlapping job using binary search
            int last = findLastNonOverlapping(jobs, i);
            if (last != -1)
                profit += dp[last];
            
            // Step 5: Take max of including or excluding current job
            dp[i] = Math.max(profit, dp[i - 1]);
        }
        
        return dp[n - 1];
    }
    
    // Binary search to find last job that doesn't overlap
    private int findLastNonOverlapping(int[][] jobs, int index) {
        int low = 0, high = index - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[index][0]) {
                if (jobs[mid + 1][1] <= jobs[index][0])
                    low = mid + 1;
                else
                    return mid;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
