public class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        
        int count = 0;
        int reach = 0;
        int nextReach = 0;
        for(int i = 0; i < nums.length - 1 && i <= reach; i++) {
            nextReach = Math.max(nextReach, nums[i] + i);
            if (i == reach) {
                // extend reach to the next possible reach
                reach = nextReach;
                count++;
            }
            if (reach >= nums.length - 1) {
                break;
            }
        }
        return count;
    }
}
