public class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer min1 = null;
        Integer min2 = null;
        Integer min = null;
        for(int i = 0; i < nums.length; i++) {
            if (min1 == null) {
                min1 = nums[i];
            } else if (nums[i] <= min1) {
                if (min != null) {
                    if (nums[i] <= min) {
                        min = nums[i];
                    } else {
                        min1 = min;
                        min2 = nums[i];
                        min = null;
                    }
                } else if (min2 == null) {
                    min1 = nums[i];
                } else {
                    min = nums[i];
                }
            } else if (min2 == null || nums[i] <= min2) {
                min2 = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
