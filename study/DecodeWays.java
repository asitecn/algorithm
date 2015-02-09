public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        dp[0][0] = (s.charAt(0) == '0' ? 0 : 1);
        for(int i = 1; i < n; i++) {
            char lc = s.charAt(i-1);
            char tc = s.charAt(i);
            if (tc != '0') {
                System.out.println(i);
                dp[i][i] = 1;
            }
            if (lc == '0') {
                dp[i-1][i] = 0;
            } else {
                int value = (lc - '0') * 10 + (tc - '0');
                if (value % 10 == 0) {
                    dp[i-1][i] = (value <= 20 ? 1 : 0);
                } else if (value > 10 && value <= 26) {
                    dp[i-1][i] = 2;
                } else {
                    dp[i-1][i] = 1;
                }
            }
        }
        for(int i = n-3; i >= 0; i--) {
            for(int j = i+2; j < n; j++) {
System.out.println(i + "\t" + j + "\t" + dp[i][i] + "\t" +dp[i+1][j] + "\t" + dp[i][i+1] + "\t" + dp[i+2][j]);
                dp[i][j] = Math.min(dp[i][i], dp[i+1][j]) + Math.min(dp[i][i+1], dp[i+2][j]);
            }
        }
        return dp[0][n-1];
    }

    public static void main(String args[]) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("101"));
    }
}
