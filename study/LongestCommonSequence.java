public class LongestCommonSequence {

    public String longestSequence(String a, String b) {
        String[][] dp = new String[a.length()+1][b.length()+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = "";
        }
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = "";
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + a.charAt(i-1);
                } else {
                    dp[i][j] = (dp[i-1][j].length() > dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public int longest(String a, String b) {
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
        System.out.println(lcs.longest("ACCG", "CCAGCA"));
        System.out.println(lcs.longestSequence("ACCG", "CCAGCA"));
    }

}
