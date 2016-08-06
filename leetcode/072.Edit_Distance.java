public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                dp[i][j] = dp[i-1][j-1] + (c1 == c2 ? 0 : 1);
                dp[i][j] = Math.min(Math.min(dp[i][j], dp[i-1][j] + 1), dp[i][j-1] + 1);
            }
        }
        return dp[m][n];
    }
}
