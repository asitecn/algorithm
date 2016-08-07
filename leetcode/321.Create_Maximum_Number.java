public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int maxNum1 = Math.min(nums1.length, k);
        int[] max = new int[k];
        for(int i = 0; i <= maxNum1; i++) {
            if (k - i > nums2.length) {
                continue;
            }
            //System.out.println("i=" + i + ", k-i=" + (k-i));
            int[] max1 = maxNumber(nums1, i);
            int[] max2 = maxNumber(nums2, k - i);
            int[] res = merge(max1, max2);

            //System.out.println("max1=" + Arrays.toString(max1));
            //System.out.println("max2=" + Arrays.toString(max2));
            //System.out.println("max3=" + Arrays.toString(res));
            
            if (greater(res, 0, max, 0)) {
                max = res;
            }
        }
        return max;
    }
    
    public int[] merge(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] res = new int[nums1.length + nums2.length];
        while(i < nums1.length && j < nums2.length) {
            if (greater(nums1, i, nums2, j)) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }
        while(i < nums1.length) {
            res[k++] = nums1[i++];
        }
        while(j < nums2.length) {
            res[k++] = nums2[j++];
        }
        return res;
    }
    
    public boolean greater(int[] nums1, int pos1, int[] nums2, int pos2) {
        while(pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] > nums2[pos2]) {
                return true;
            } else if (nums1[pos1] < nums2[pos2]) {
                return false;
            }
            pos1++;
            pos2++;
        }
        return (pos2 == nums2.length);
    }
    
    public int[] maxNumber(int[] nums, int k) {
        int index = 0;
        int count = 0;
        int[] res = new int[k];
        while(count < k) {
            int max = 0;
            for(int i = index; i + (k - count) <= nums.length; i++) {
                if (max < nums[i]) {
                    max = nums[i];
                    index = i;
                }
            }
            //System.out.println("count=" + count + ", index=" + index);
            res[count++] = nums[index++];
        }
        return res;
    }
}
