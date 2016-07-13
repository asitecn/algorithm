public class Solution {
    /* swapping
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void permute(List<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length) {
            List<Integer> path = new ArrayList<Integer>();
            for(int num : nums) {
                path.add(num);
            }
            res.add(path);
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            permute(res, nums, pos + 1);
            swap(nums, pos, i);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(res, nums, 0);
        return res;
    }
    */

    // construction
    public void permute(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            permute(res, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(res, path, nums, visited);
        return res;
    }
}
