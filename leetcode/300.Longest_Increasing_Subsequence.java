// Solution 1, dynamic programming, n^2, 32ms
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // Given [10, 9, 2, 5, 3, 7, 101, 18],
        // The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length. 
        
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i] + 1, max);
        }
        return max;
    }
}

// Solution 2, search, nlog(n), 3ms

public class Solution {
    public int lengthOfLIS(int[] nums) {
        // Given [10, 9, 2, 5, 3, 7, 101, 18],
        // The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
        
        /* method 1  dynamic programming 
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max + 1;
        */
        
        /* method 2 search */
        int len = 0;
        int[] sequence = new int[nums.length];
        for (int num : nums) {
            int idx = Arrays.binarySearch(sequence, 0, len, num);
            if (idx < 0) {
                idx = - (idx + 1);
            }
            sequence[idx] = num;
            if (idx == len) {
                len++;
            }
        }
        return len;
    }
}
