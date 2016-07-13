public class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
            Here are few examples.
            [1,3,5,6], 5 → 2
            [1,3,5,6], 2 → 1
            [1,3,5,6], 7 → 4
            [1,3,5,6], 0 → 0 
       */
       
       int i = 0;
       int j = nums.length - 1;
       while(i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
       }
       return i;
    }
}
