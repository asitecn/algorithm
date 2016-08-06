public class Solution {

    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i <= j) {
            while (i < j && nums[i] == nums[j]) {
                j--;
            }
            while (i < j && nums[i] == nums[i+1]) {
                i++;
            }
            if (nums[i] <= nums[j]) {
                return nums[i];
            }
            int mid = i + (j - i) / 2;
            if (nums[mid] < nums[i]) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        
        return -1;
    }
}
