// Solution 1
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    } 
    
    public void sortColors(int[] nums) {
        int midStart = 0;
        int midEnd = 0;
        int midVal = 1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == midVal) {
                swap(nums, i, midEnd++);
            } else if (nums[i] < midVal) {
                swap(nums, i, midEnd);
                swap(nums, midEnd++, midStart++);
            }
        }
    }
}

// Solution 2
public class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        int p2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                nums[p2++] = 2;
            } else if (nums[i] == 1) {
                nums[p2++] = 2;
                nums[p1++] = 1;
            } else {
                nums[p2++] = 2;
                nums[p1++] = 1;
                nums[p0++] = 0;
            }
        }
    }
}
