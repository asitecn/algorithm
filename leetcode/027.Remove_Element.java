public class Solution {
    public int removeElement(int[] nums, int val) {
        // Given input array nums = [3,2,2,3], val = 3
        // Your function should return length = 2, with the first two elements of nums being 2.

        int w = 0;
        for(int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[w++] = nums[r];
            }
        }
        return w;
    }
}
