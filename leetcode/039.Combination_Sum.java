public class Solution {
    
    public void combinationSum(List<List<Integer>> res, List<Integer> path, int[] candidates, int pos, int target) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                combinationSum(res, path, candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        combinationSum(res, path, candidates, 0, target);
        return res;
    }
}
