public class Solution {
    /* binary search
    public int findDuplicate(int[] nums, int s, int e) {
        if (e - s <= 1) {
            return nums[s];
        }
        int mid = s + (e - s) / 2;
        if (nums[e] - nums[mid] < e - mid) {
            return findDuplicate(nums, mid, e);
        }
        return findDuplicate(nums, s, mid);
    }
    
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        return findDuplicate(nums, 0, nums.length - 1);
    }
    */
    
    public int findDuplicate(int[] nums) {
        // think of it as a linked list
        
        int head = nums.length;
        int slow = head;
        int fast = head;
        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);
        slow = head;
        while(slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }
    
}
