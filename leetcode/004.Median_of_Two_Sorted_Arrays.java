public class Solution {
    public double kth(int[] nums1, int s1, int[] nums2, int s2, int k) {
        if (nums1.length - s1 > nums2.length - s2) {
            return kth(nums2, s2, nums1, s1, k);
        }
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        
        int key1 = Math.min(s1 + k/2 - 1, nums1.length - 1); 
        int k1items = key1 - s1 + 1;
        int k2items = k - k1items;
        int key2 = s2 + k2items - 1;
        if (nums1[key1] < nums2[key2]) {
            return kth(nums1, key1 + 1, nums2, s2, k - k1items);
        }
        return kth(nums1, s1, nums2, key2 + 1, k - k2items);
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 1) {
            return kth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return (kth(nums1, 0, nums2, 0, total / 2) + kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
        }
    }
}
