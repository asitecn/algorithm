public class Solution {
    public int rob(int[] nums, int s, int e) {
        if (s > e) {
            return 0;
        }
        int[] dp = new int[e - s + 1];
        for(int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i] = nums[s + i];
            } else if (i == 1) {
                dp[i] = Math.max(nums[s], nums[s+1]);
            } else {
                dp[i] = Math.max(nums[s + i] + dp[i-2], dp[i-1]);
            }
        }
        return dp[dp.length - 1];
    }
    
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return Math.max(nums[0] + rob(nums, 2, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
