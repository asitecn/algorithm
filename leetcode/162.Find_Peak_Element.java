public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((m == 0 || nums[m] > nums[m-1]) && (m == nums.length - 1 || nums[m] > nums[m+1])) {
                return m;
            }
            if (m > 0 && nums[m] <= nums[m-1]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
