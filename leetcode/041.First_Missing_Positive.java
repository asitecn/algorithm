public class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int firstMissingPositive(int[] nums) {
        // 3, 4, -1, 1
        // 
        for(int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] <= nums.length && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }
        return nums.length + 1;
    }
}
