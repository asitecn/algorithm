public class Solution {
    public void addRange(List<String> res, int lower, int higher) {
        res.add("" + lower + (lower == higher ? "" : "->" + higher));
    }
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if (lower < nums[i]) {
                // there is gap
                addRange(res, lower, Math.min(nums[i] - 1, upper));
            }
            lower = nums[i] + 1;
            if (lower > upper) {
                break;
            }
        }
        if (lower <= upper) {
            addRange(res, lower, upper);
        }
        return res;
    }
}
