public class Solution {
    public int bulbSwitch(int n) {
        // At first, the three bulbs are [off, off, off].
        // After first round, the three bulbs are [on, on, on].
        // After second round, the three bulbs are [on, off, on].
        // After third round, the three bulbs are [on, off, off].
        
        /*
        int[] bulbs = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j+=i+1) {
                bulbs[j] = (bulbs[j] == 0 ? 1 : 0);
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += bulbs[i];
        }
        return sum;
        */
        
        // 0, 0, 0, 0, 0, 0, 0, 0, 0
        // 1, 1, 1, 1, 1, 1, 1, 1, 1
        // 1, 0, 1, 0, 1, 0, 1, 0, 1
        // 1, 0, 0, 0, 1, 1, 1, 0, 0
        // 1, 0, 0, 1, 1, 1, 1, 1, 0
        // 1, 0, 0, 1, 0, 1, 1, 1, 0
        
        // 1, 2, 3, 4, 5, 6, 7, 8
        // 1, 2, 2, 3, 2, 4, 2, 4

        int sum = 0;
        int idx = 1;
        while(idx*idx <= n) {
            sum++;
            idx++;
        }
        return sum;
    }
}
