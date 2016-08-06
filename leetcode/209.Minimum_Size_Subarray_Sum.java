public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        // sliding window!

        /*
        For example, given the array [2,3,1,2,4,3] and s = 7,
        the subarray [4,3] has the minimal length under the problem constraint.        
        */
        
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(end < nums.length) {
            sum += nums[end++];
            while(sum >= s) {
                minLen = Math.min(minLen, end - start);
                sum -= nums[start++];
            }
        }

        return (minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}
