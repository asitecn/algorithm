public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int j = 0; j < n; j++) {
            dp[j] += (j == 0 ? 0 : dp[j-1]) + grid[0][j];
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[j] = (j == 0 ? dp[j] : Math.min(dp[j-1], dp[j])) + grid[i][j];
            }
        }
        return dp[n-1];
    }
}
