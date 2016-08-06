public class Solution {
    public int maxSubArray(int[] nums) {
        // For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
        // the contiguous subarray [4,−1,2,1] has the largest sum = 6.        
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while(end < nums.length) {
            sum += nums[end++];
            max = Math.max(sum, max);
            if (sum < 0) {
                start = end;
                sum = 0;
            }
        }
        return max;
    }
}
