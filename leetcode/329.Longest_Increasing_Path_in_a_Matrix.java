public class Solution {
    
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] visited) {
        if (visited[i][j] > 0) {
            return visited[i][j];
        }
        int res = 1;
        if (i > 0 && matrix[i-1][j] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i-1, j, m, n, visited));
        }
        if (i < m - 1 &&  matrix[i+1][j] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i+1, j, m, n, visited));
        }
        if (j > 0 &&  matrix[i][j-1] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i, j-1, m, n, visited));
        }
        if (j < n - 1 && matrix[i][j+1] > matrix[i][j]) {
            res = Math.max(res, 1 + dfs(matrix, i, j+1, m, n, visited));
        }
        visited[i][j] = res;
        return res;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(dfs(matrix, i, j, m, n, visited), max);
            }
        }
        return max;
    }
}
