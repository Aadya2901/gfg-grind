class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;
        
        int[] map1 = new int[256];  // s1 -> s2
        int[] map2 = new int[256];  // s2 -> s1
        
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            // If both not mapped yet
            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2;
                map2[c2] = c1;
            }
            // If mapping not consistent
            else {
                if (map1[c1] != c2 || map2[c2] != c1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}