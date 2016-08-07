public class Solution {
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int p = start;
        for(int i = start; i <= end - 1; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p++);
            }
        }
        swap(nums, end, p);
        return p;
    }
    
    
    public int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        int p = partition(nums, start, end);
        if (k == p) {
            return nums[k];
        }
        if (k < p) {
            return quickSelect(nums, start, p - 1, k);
        } else {
            return quickSelect(nums, p + 1, end, k);
        }
    }
    
    public void sort3Ways(int[] nums, int median) {
        int medianStart = 0;
        int medianEnd = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == median) {
                swap(nums, medianEnd++, i);
            } else if (nums[i] < median) {
                swap(nums, medianStart++, i);
                swap(nums, i, medianEnd++);
            }
        }
    }
    
    public void reverse(int[] nums, int s, int e) {
        while(s < e) {
            swap(nums, s++, e--);
        }
    }
    
    public void wiggleSort(int[] nums) {
        int median = quickSelect(nums, 0, nums.length - 1, (nums.length + 1) / 2 - 1);
        // 0, 1, 2, 3, 4       5 => 5 / 2 = 2 (2)
        // 0, 1  2, 3, 4, 5    6 => 6 / 2 = 3 (2)
        
        // 1,1,1, 2, | 2, 4, 5, 6 ===> 2 is the median
        // 1,1,1,   |2|   2,5,6  temp
        // 1, 2, 1, 5, 1, 6 2     num
        sort3Ways(nums, median);
        
        int[] left = new int[(nums.length + 1) / 2];
        int[] right = new int[nums.length - (nums.length + 1) / 2]; 
        for(int i = 0; i < left.length; i++) {
            left[i] = nums[left.length - 1 - i];
        }
        for(int i = 0; i < right.length; i++) {
            right[i] = nums[nums.length -1 - i];
        }
        for(int i = 0, l=0, r=0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0 ? left[l++] : right[r++]);
        }
    }
}
