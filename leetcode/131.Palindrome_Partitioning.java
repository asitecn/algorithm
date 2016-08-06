public class Solution {
    public void partition(List<List<String>> res, List<String> path, String s, boolean[][] dp, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                path.add(s.substring(pos, i+1));
                partition(res, path, s, dp, i+1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0; i + gap < n; i++) {
                int j = i + gap;
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition(res, path, s, dp, 0);
        return res;
    }
}
