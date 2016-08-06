public class Solution {
    
    public void combinationSum3(List<List<Integer>> res, List<Integer> path, int k, int n, int start) {
        if (path.size() == k) {
            if (n == 0) {
                res.add(new ArrayList<Integer>(path));
            }
            return;
        }
        
        for(int i = start; i <= 9 && i <= n; i++) {
            path.add(i);
            combinationSum3(res, path, k, n - i, i + 1);
            path.remove(path.size() - 1);
        }
    }
    
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum3(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
}
