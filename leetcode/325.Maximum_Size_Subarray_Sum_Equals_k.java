public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        // Given nums = [-1, 1, 5, -2, 3], k = 3,
        // return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else {
                if (map.containsKey(sum - k)) {
                    max = Math.max(max, i - map.get(sum - k));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
