public class Solution {
    public void moveZeroes(int[] nums) {
        //  For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]. 
        
        int w = 0;
        for(int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                nums[w++] = nums[r];
            }
        }
        for(; w < nums.length; w++) {
            nums[w] = 0;
        }
    }
}
