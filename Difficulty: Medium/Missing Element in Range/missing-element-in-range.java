class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        
        // store array elements in HashSet
        for(int num : arr) {
            set.add(num);
        }
        
        // check all numbers in range
        for(int i = low; i <= high; i++) {
            if(!set.contains(i)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}
