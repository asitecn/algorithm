public class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i = 0; i < nums.length - 1 && i <= maxReach; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return (nums.length <= 1 ? true : false);
    }
}
