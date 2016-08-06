public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        
        int count = 0;
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            if (count == 0 || nums[i] == num) {
                num = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
