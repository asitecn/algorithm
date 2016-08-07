public class Solution {
    public int integerBreak(int n) {
        //  For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4). 
        if (n <= 1) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(j*dp[i-j], dp[i]);
            }
            if (i != n) {
                dp[i] = Math.max(i, dp[i]);
            }
        }
        return dp[n];
    }
}
