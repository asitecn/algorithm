public class Solution {
    public int minPatches(int[] nums, int n) {
        int index = 0;
        long maxReach = 0;
        int count = 0;
        while(maxReach < n) {
            long nextReach = maxReach + 1;
            if (index < nums.length && nums[index] <= nextReach) {
                maxReach += nums[index++];
            } else {
                maxReach += nextReach;
                count++;
            }
        }
        return count;
    }
}
