import java.util.*;
public class LongestIncreasingSequence {
   
    public List<Integer> longest(int[] arr) {
        List<Integer>[] dp = new List[arr.length];
        for(int i = 0; i < arr.length; i++) {
            dp[i] = new ArrayList<Integer>();
        }
        dp[0].add(arr[0]);
        int maxIdx = 0;

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i].size() < dp[j].size()) {
                    dp[i] = new ArrayList<Integer>(dp[j]);
                }
            }
            dp[i].add(arr[i]);
            if (dp[i].size() > dp[maxIdx].size()) {
                maxIdx = i;
            }
        }

        for(Integer i : dp[maxIdx]) {
            System.out.print(i + "\t");
        }
        System.out.println();
        return dp[maxIdx];
    }


    public static void main(String args[]) {
        int[] arr = new int[]{3, 2, 6, 4, 5, 1};

        LongestIncreasingSequence lis = new LongestIncreasingSequence();
        lis.longest(arr);
    }
}
