public class Solution {
    
    public void subsets(List<List<Integer>> lists, List<Integer> path, int[] nums, int pos) {
        lists.add(new ArrayList<>(path));
        for(int i = pos; i < nums.length; i++) {
            path.add(nums[i]);
            subsets(lists, path, nums, i+1);
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
}
