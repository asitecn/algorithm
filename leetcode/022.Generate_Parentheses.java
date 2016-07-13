public class Solution {
    public void generateParenthesis(List<String> res, String path, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }
        if (left < right) {
            generateParenthesis(res, path + ")", left, right - 1);
        }
        if (left > 0) {
            generateParenthesis(res, path + "(", left - 1, right);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(res, "", n, n);
        return res;
    }
}
