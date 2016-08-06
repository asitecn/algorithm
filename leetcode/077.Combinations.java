public class Solution {
    
    public void combine(List<List<Integer>> res, List<Integer> path, int n, int k, int pos) {
        if (path.size() == k) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = pos; i <= n; i++) {
            path.add(i);
            combine(res, path, n, k, i+1);
            path.remove(path.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, new ArrayList<Integer>(), n, k, 1);
        return res;
    }
}
