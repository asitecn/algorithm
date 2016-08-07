public class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                nums[i] = 1;
            } else {
                nums[i] = iNums[i - 1];
            }
        }

        int[][] dp = new int[n][n];
        for(int k = 2; k < n; k++) {
            for(int left = 0; left + k < n; left++) {
                int right = left + k;
                for(int mid = left + 1; mid < right; mid++) {
                    dp[left][right] = Math.max(dp[left][right], 
                        dp[left][mid] + dp[mid][right] + nums[left]*nums[mid]*nums[right]);
                }
            }
        }
        return dp[0][n-1];
    }
}
