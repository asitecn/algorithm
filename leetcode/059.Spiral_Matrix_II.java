public class Solution {
    public void generateMatrix(int[][] matrix, int i1, int j1, int i2, int j2, int count) {
        if (i1 > i2 || j1 > j2) {
            return;
        }
        if (i1 == i2 && j1 == j2) {
            matrix[i1][j1] = count++;
            return;
        } 
        for(int j = j1; j < j2; j++) {
            matrix[i1][j] = count++;
        }
        for(int i = i1; i < i2; i++) {
            matrix[i][j2] = count++;
        }
        for(int j = j2; j > j1; j--) {
            matrix[i2][j] = count++;
        }
        for(int i = i2; i > i1; i--) {
            matrix[i][j1] = count++;
        }
        generateMatrix(matrix, i1 + 1, j1 + 1, i2 - 1, j2 - 1, count);
    }
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        generateMatrix(matrix, 0, 0, n-1, n-1, 1);
        return matrix;
    }
}
