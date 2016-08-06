public class Solution {

    public void subsets(List<List<Integer>> res, List<Integer> path, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(path));
        for(int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            subsets(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
}
