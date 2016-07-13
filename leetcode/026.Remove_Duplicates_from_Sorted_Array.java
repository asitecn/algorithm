public class Solution {
    public int removeDuplicates(int[] nums) {
        int w = 0;
        for(int r = 0; r < nums.length; r++) {
            if (r == 0) {
                w++;
            } else {
                if (nums[r] != nums[r-1]) {
                    nums[w++] = nums[r];
                }
            }
        }
        return w;
    }
}
