public class Solution {
    public int removeDuplicates(int[] nums) {
        Integer num = null;
        int count = 0;
        int w = 0;
        for(int i = 0; i < nums.length; i++) {
            if (num == null || num != nums[i]) {
                num = nums[i];
                nums[w++] = nums[i];
                count = 1;
            } else if (count == 1) {
                nums[w++] = nums[i];
                count = 2;
            }
        }
        
        return w;
    }
}
