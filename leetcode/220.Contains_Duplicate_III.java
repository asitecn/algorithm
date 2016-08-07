public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < nums.length; i++) {
            long lower = (long)nums[i] - t;
            long higher = (long)nums[i] + t;
            Long floor = set.floor(higher);
            if (floor != null && floor >= lower) {
                return true;
            }
    
            if (i >= k) {
                set.remove(new Long(nums[i - k]));
            }
            set.add(new Long(nums[i]));
        }
        return false;
    }
}
