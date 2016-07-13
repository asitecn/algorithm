public class Solution {
    
    public int findOneIndex(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int m = l + (r-l) / 2;
            if (nums[m] == target) {
                index = m;
                break;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return index;
    }
    
    public int firstLeft(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r-l) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    public int lastRight(int[] nums, int l, int r, int target) {
        while (l < r) {
            int m = l + (r-l+1) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    
    public int[] searchRange(int[] nums, int target) {
        // Given [5, 7, 7, 8, 8, 10] and target value 8,
        // return [3, 4]. 

        int index = findOneIndex(nums, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        
        return new int[]{firstLeft(nums, 0, index, target), lastRight(nums, index, nums.length - 1, target)};
    }
}
