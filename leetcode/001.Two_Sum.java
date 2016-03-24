public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return new int[]{map.get(nums[i])+1, i+1};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
