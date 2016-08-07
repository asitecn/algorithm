// Solution 1, 1ms
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i] ^ i;
        }
        xor ^= nums.length;
        return xor;
    }
}


// Solution 2, 3ms
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] < nums.length && nums[i] != i) {
                swap(nums, nums[i], i);
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
