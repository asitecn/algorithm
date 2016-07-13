public class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i++, j--);
        }
    }
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int k = -1;
        for(int i = nums.length - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                k = i - 1;
                break;
            }
        }
        if (k == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int l = -1;
        for(int i = nums.length - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                l = i;
                break;
            }
        }
        swap(nums, k, l);
        reverse(nums, k+1, nums.length - 1);
    }
}
