import java.util.*;

class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < n; i++) {
            sum += (a1[i] - a2[i]);
            
            // If prefix sum becomes 0
            if(sum == 0) {
                maxLen = i + 1;
            }
            
            // If same sum seen before
            if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i); // store first occurrence
            }
        }
        
        return maxLen;
    }
}