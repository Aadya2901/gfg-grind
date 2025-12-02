class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
        int cnt = 0;
    }

    static final int MAX_BIT = 15;
    TrieNode root;

    void insert(int num) {
        TrieNode node = root;
        for (int b = MAX_BIT; b >= 0; b--) {
            int bit = (num >> b) & 1;
            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }
            node = node.child[bit];
            node.cnt++;
        }
    }

    int countLess(int x, int k) {
        TrieNode node = root;
        int ans = 0;

        for (int b = MAX_BIT; b >= 0; b--) {
            if (node == null) break;

            int xb = (x >> b) & 1;
            int kb = (k >> b) & 1;

            if (kb == 1) {
                // XOR bit = 0 → y-bit = x-bit
                if (node.child[xb] != null)
                    ans += node.child[xb].cnt;

                // Continue with XOR bit = 1 → y-bit != x-bit
                node = node.child[xb ^ 1];
            } else {
                // kb == 0 → XOR must be 0 → follow same bit
                node = node.child[xb];
            }
        }
        return ans;
    }

    public int cntPairs(int[] arr, int k) {
        root = new TrieNode();
        int total = 0;

        for (int x : arr) {
            total += countLess(x, k);
            insert(x);
        }

        return total;
    }
}
