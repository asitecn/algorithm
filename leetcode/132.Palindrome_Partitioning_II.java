public class Solution {
    public int minCut(String s) {
        
        // invaints are:
        // cut[i] is the min-required for first i character
        // isp[j][i] should contain all answers for j <= i - 1; 
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j));
                if (i - j >= 2) {
                    dp[j][i] &= dp[j+1][i-1];
                }
            }
        }
        
        int[] cut = new int[n];
        Arrays.fill(cut, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    min = (j == 0 ? 0 : Math.min(min, cut[j-1] + 1)); 
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
}
