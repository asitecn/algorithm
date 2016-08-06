public class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        if (N == 0) {
            return 0;
        }
        
        int[] dp = new int[N];
        for(int i = 0; i < N; i++) {
            List<Integer> list = triangle.get(i);
            if (i == 0) {
                dp[i] = list.get(0);
                continue;
            }
            dp[list.size() - 1] = dp[list.size() - 2] + list.get(list.size() - 1);
            for(int j = list.size() - 2; j >= 1; j--) {
                dp[j] = Math.min(dp[j-1], dp[j]) + list.get(j);
            }
            dp[0] += list.get(0);
            //System.out.println(dp[0] + "\t" + dp[1]);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}
