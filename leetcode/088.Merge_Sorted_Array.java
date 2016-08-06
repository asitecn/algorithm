public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int w = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[w--] = nums1[i--];
            } else {
                nums1[w--] = nums2[j--];
            }
        }
    }
}
