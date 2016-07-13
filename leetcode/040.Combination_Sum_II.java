public class Solution {
    
    public void combinationSum2(List<List<Integer>> res, List<Integer> path, int[] candidates, int pos, int target, int sum) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            // this case should already be covered by the next iteration (i+1).
            if (i > pos && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (sum + candidates[i] <= target) {
                path.add(candidates[i]);
                combinationSum2(res, path, candidates, i + 1, target, sum + candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum2(res, path, candidates, 0, target, 0);
        return res;
    }
}
