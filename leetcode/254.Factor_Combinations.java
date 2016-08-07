public class Solution {

    public List<List<Integer>> getFactors(int n, int start) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = start; i*i <= n; i++) {
            if (n % i == 0) {
                List<List<Integer>> prev = getFactors(n/i, i);
                for(List<Integer> p : prev) {
                    p.add(0, i);
                    res.add(p);
                }
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                list.add(n/i);
                res.add(list);
            }
        }
        return res;
    }
    
    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2);
    }
}
