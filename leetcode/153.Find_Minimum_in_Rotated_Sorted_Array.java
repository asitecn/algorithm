public class Solution {
    /* recursion
    public int findMin(int[] nums, int l, int r) {
        if (nums[l] < nums[r] || l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] >= nums[l]) {
            return findMin(nums, mid + 1, r);
        }
        return findMin(nums, l, mid);
    }
    
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }
    */

    public int findMin(int[] nums) {
        // iterative
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] < nums[j] || i == j) {
                return nums[i];
            }
            int mid = i + (j - i) / 2;
            if (nums[mid] >= nums[i]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return -1;
    }
    
}
