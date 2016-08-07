public class Solution {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int count = 0;
    
    public int strobogrammaticInRange(String low, String high) {
        int[][] dp = new int[high.length()][2];
        for(int i = 0; i < dp.length; i++) {
            if (i == 0) {
                dp[i][0] = 3;
                dp[i][1] = 3;
            } else if (i == 1) {
                dp[i][0] = 5;
                dp[i][1] = 4;
            } else {
                dp[i][0] = 5 * dp[i - 2][0];
                dp[i][1] = 4 * dp[i - 2][0];
            }
        }

        for (int len = low.length(); len <= high.length(); len++) {
            if (len == low.length() || len == high.length()) {
                char[] ch = new char[len];
                dfs(low, high, ch, 0, len - 1);
            } else {
                count += dp[len - 1][1];
            }
        }
        
        return count;
    }
    
    public void dfs(String low, String high, char[] ch, int left, int right) {
        if (left > right) {
            String s = new String(ch);
            if ((s.length() > low.length() || s.compareTo(low) >= 0) && (s.length() < high.length() || s.compareTo(high) <= 0)) {
                count++;
            }
            return;
        }
        
        for (char[] pair : pairs) {
            ch[left] = pair[0];
            ch[right] = pair[1];
            if (ch[0] == '0' && ch.length > 1) {
                continue;
            }
            if (left < right || (left == right && pair[0] == pair[1])) {
                dfs(low, high, ch, left+1, right-1);
            }
        }
    }

}
