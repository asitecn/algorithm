public class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public int partition(int[] nums, int s, int e) {
        int pivot = nums[e];
        int w = s;
        for(int r = s; r <= e - 1; r++) {
            if (nums[r] > pivot) {
                swap(nums, w++, r);
            }
        }
        swap(nums, w, e);
        return w;
    }
    
    public int findKthLargest(int[] nums, int s, int e, int k) {
        int pivotIdx = partition(nums, s, e);
        if (pivotIdx == k) {
            return nums[k];
        } 
        if (pivotIdx < k) {
            return findKthLargest(nums, pivotIdx + 1, e, k);
        }
        return findKthLargest(nums, s, pivotIdx - 1, k);
    }
    
    
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }
}
