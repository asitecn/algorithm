public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int s0 = 0;
        int s1 = -prices[0];
        int s2 = 0;
        int last_s2 = 0;
        for(int i = 0; i < prices.length; i++) {
            last_s2 = s2;
            s1 = Math.max(s1, s0 - prices[i]);
            if (i >= 1) {
                s2 = Math.max(s2, s1 + prices[i]);
            }
            if (i >= 2) {
                s0 = Math.max(last_s2, s0);
            }
        }
        
        return Math.max(s0, s2);
    }
}
