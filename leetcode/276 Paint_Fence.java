public class Solution {
    public int numWays(int n, int k) {
        int[] dp = new int[]{k, k*k, 0};
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return dp[0];
        }
        for(int i = 2; i < n; i++) {
            dp[2] = (dp[0] + dp[1]) * (k-1);
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[1];
    }
}
