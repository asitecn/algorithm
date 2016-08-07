public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        
        int num = 1; 
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            if (num*num == i) {
                dp[i] = 1;
                num++;
            } else {
                for(int j = 1; j < num; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
                }
            }
        }
        return dp[n];
    }
}
