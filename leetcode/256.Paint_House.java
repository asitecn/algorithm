public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        //int[][] dp = new int[costs.length][costs[0].length];
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        
        for(int i = 0; i < costs.length; i++) {
            int lc0 = c0;
            int lc1 = c1;
            int lc2 = c2;
            c0 = Math.min(lc1, lc2) + costs[i][0];
            c1 = Math.min(lc0, lc2) + costs[i][1];
            c2 = Math.min(lc0, lc1) + costs[i][2];
        }
        
        return Math.min(c0, Math.min(c1, c2));
    }
}
