public class Distinct {
    public int numDistinct2(String S, String T) {
        int[][] dp = new int[1+T.length()][1+S.length()];
        for(int j = 0; j < S.length(); j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i <= T.length(); i++) {
            for(int j = 1; j <= S.length(); j++) {
                if (T.charAt(i-1) != S.charAt(j-1)) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }

    public void print(int[] dp) {
        for(int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
        }
        System.out.println();
    }
    
    public int numDistinct(String S, String T) {
        int[] dp = new int[T.length()+1];
        dp[0] = 1;

        for(int s=1; s<=S.length(); s++) {
            for(int t=T.length(); t>=1; t--){
                if(S.charAt(s-1)==T.charAt(t-1)) {
                    dp[t] += dp[t-1];
                }
            }
            print(dp);
        }

        return dp[T.length()];
    }

    public static void main(String args[]) {
        Distinct d = new Distinct();
        d.numDistinct("rabbbit", "rabbit");
    }
}
