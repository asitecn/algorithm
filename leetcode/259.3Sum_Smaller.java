public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int j = i+1;
            int k = nums.length - 1;
            int remain = target - nums[i];
            while(j < k) {
                if (nums[j] + nums[k] < remain) {
                    sum += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }
}
