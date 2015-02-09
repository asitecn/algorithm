public class CanJumpII {
    public int jump(int[] A) {
        int[] dp = new int[A.length];
        for(int i = 0; i < dp.length-1; i++) {
            if (A[i] + i >= dp.length-1) {
//                System.out.println(i);
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
            }
        }
        if (dp[0] == 1) {
            return 1;
        }
        
        for(int i = dp.length-1; i >= 0; i--) {
            if (dp[i] == 1) {
                continue;
            }
            for(int k = A[i]; k >= 1 && i+k < dp.length-1; k--) {
                dp[i] = Math.min(dp[i], 1 + dp[i+k]);
//                System.out.println(i + "\t" +dp[i]);
            }
        }
        return dp[0];
    }

    public static void main(String args[]) {
        CanJumpII c = new CanJumpII();
        int[] A = new int[25002];
        for(int i = 0; i < A.length-2; i++) {
            A[i] = 25000 - i;
        }
        A[25000] = 1;
        A[25001] = 0;
        System.out.println(c.jump(A));
    }
}
