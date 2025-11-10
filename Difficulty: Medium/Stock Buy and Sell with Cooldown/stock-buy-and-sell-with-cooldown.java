class Solution {
    public int maxProfit(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int buy = -arr[0];  // profit when we buy stock
        int sell = 0;       // profit when we sell stock
        int cool = 0;       // profit during cooldown

        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            int prevSell = sell;
            int prevCool = cool;

            buy = Math.max(prevBuy, prevCool - arr[i]);
            sell = prevBuy + arr[i];
            cool = Math.max(prevCool, prevSell);
        }

        // The maximum profit is either in sell or cooldown state
        return Math.max(sell, cool);
    }
}
