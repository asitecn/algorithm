public class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            while(i <= j && i < nums.length - 2 && nums[i] == nums[i+1]) {
                i++;
            }
            while(j >= i && j > 0 && nums[j] == nums[j-1]) {
                j--;
            }
            int m = i + (j - i) / 2;
            if (nums[m] == target) {
                return true;
            }
            if (nums[m] >= nums[i]) {
                if (nums[i] <= target && target < nums[m]) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[j]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return false;
    }
}
