import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int maxLen = -1;
        
        for(int right = 0; right < s.length(); right++) {
            
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            // shrink window if distinct > k
            while(map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                
                left++;
            }
            
            // update result if exactly k distinct
            if(map.size() == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        return maxLen;
    }
}