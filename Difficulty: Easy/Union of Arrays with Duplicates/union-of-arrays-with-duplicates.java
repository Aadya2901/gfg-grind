import java.util.*;

class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        
        HashSet<Integer> set = new HashSet<>();
        
        // Add elements of first array
        for (int num : a) {
            set.add(num);
        }
        
        // Add elements of second array
        for (int num : b) {
            set.add(num);
        }
        
        // Convert set to ArrayList
        return new ArrayList<>(set);
    }
}