public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        int[] prev = new int[n];
        int[] cur = new int[n];
        for(int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                prev[j] = 1;
                max = 1;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    cur[j] = 0;
                } else {
                    if (j == 0) {
                        cur[j] = 1;
                    } else {
                        cur[j] = Math.min(Math.min(cur[j-1], prev[j]), prev[j-1]) + 1;
                    }
                    max = Math.max(max, cur[j]);
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        
        return max * max;
    }
}
