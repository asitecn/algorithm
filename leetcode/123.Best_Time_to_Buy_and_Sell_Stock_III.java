public class Solution {
    
    public int maxProfit(int[] prices) {
        int[] lmaxProfit = new int[prices.length];
        int[] rmaxProfit = new int[prices.length];
        
        int lmin = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            lmin = Math.min(prices[i], lmin);
            lmaxProfit[i] = Math.max(i == 0 ? 0 : lmaxProfit[i - 1], prices[i] - lmin);
        }
        int rmax = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--) {
            rmax = Math.max(prices[i], rmax);
            rmaxProfit[i] = Math.max(i == prices.length - 1 ? 0 : rmaxProfit[i + 1], rmax - prices[i]);
        }
        int globalMax = 0;
        for(int i = 0; i < prices.length; i++) {
            globalMax = Math.max(globalMax, lmaxProfit[i] + rmaxProfit[i]);
        }
        return globalMax;
    }
}
