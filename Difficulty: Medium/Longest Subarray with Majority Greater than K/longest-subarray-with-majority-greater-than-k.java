import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;
        
        // Store first occurrence of prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            
            // Convert problem to +1 and -1
            if (arr[i] > k)
                sum += 1;
            else
                sum -= 1;
            
            // If prefix sum > 0 → whole subarray valid
            if (sum > 0) {
                maxLen = i + 1;
            }
            
            // If sum not seen before, store first occurrence
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            
            // Check if (sum - 1) seen before
            if (map.containsKey(sum - 1)) {
                int prevIndex = map.get(sum - 1);
                maxLen = Math.max(maxLen, i - prevIndex);
            }
        }
        
        return maxLen;
    }
}