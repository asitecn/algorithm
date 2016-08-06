public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.containsKey(nums[i]-1) ? map.get(nums[i]-1)[0] : nums[i];
            int right = map.containsKey(nums[i]+1) ? map.get(nums[i]+1)[1] : nums[i];
            map.put(left, new int[]{left, right});
            if (left != right) {
                map.put(right, new int[]{left, right});
            }
            if (left != nums[i] && right != nums[i]) {
                map.put(nums[i], new int[]{left, right});
            }
        }
        int max = 0;
        for(Map.Entry<Integer, int[]> me : map.entrySet()) {
            int[] value = me.getValue();
            max = Math.max(max, value[1] - value[0] + 1);
        }
        return max;
    }
}
