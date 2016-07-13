public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int value = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return target;
                }
                
                if (diff > Math.abs(target - sum)) {
                    diff = Math.abs(target - sum);
                    value = sum;
                }
                
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return value;
    }
}
