public class Solution {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int globalMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(nums[i]*max, nums[i]*min), nums[i]);
            min = Math.min(Math.min(nums[i]*tmp, nums[i]*min), nums[i]);
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }
}
