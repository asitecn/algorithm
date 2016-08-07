public class Solution {
    public int countRangeSum(long[] sums, int s, int e, int lower, int upper) {
        if (e == s) {
            return 0;
        }
        int m = s + (e - s) / 2;
        int count = countRangeSum(sums, s, m, lower, upper) + countRangeSum(sums, m+1, e, lower, upper);

        long[] cache = new long[e - s + 1];

        // k1, k2 defines the boundary for every "i", k1, k2 can only increase.
        int k1 = m + 1;
        int k2 = m + 1;
        for(int l = s; l <= m; l++) {
            while (k1 <= e && sums[k1] - sums[l] < lower) {
                k1++;
            }
            while (k2 <= e && sums[k2] - sums[l] <= upper) {
                k2++;
            }
            count += k2 - k1;
        }
        
        // l is the index on left array;
        int l = s;
        // t represents the index in the right array
        int r = m + 1;
        // w is the index for cache.
        int w = 0;
        while (l <= m || r <= e) {
            cache[w++] = (l > m ? sums[r++] : (r > e ? sums[l++] : (
                    sums[l] < sums[r] ? sums[l++] : sums[r++]
                )));
        }
        
        System.arraycopy(cache, 0, sums, s, cache.length);
        return count;
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long[] sums = new long[nums.length+1];
        for(int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        return countRangeSum(sums, 0, sums.length - 1, lower, upper);
    }
}
