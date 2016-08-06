public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> prev = grayCode(n - 1);
        res.addAll(prev);
        int patch = 1 << (n - 1);
        for(int i = prev.size() - 1; i >= 0; i--) {
            res.add(patch | prev.get(i));
        }
        return res;
    }
}
