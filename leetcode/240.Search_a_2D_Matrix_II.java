public class Solution {

    public boolean searchMatrix(int[][] matrix, int target, int i1, int j1, int i2, int j2) {
        if (i1 > i2 || j1 > j2) {
            return false;
        }
        int mi = i1 + (i2 - i1) / 2;
        int mj = j1 + (j2 - j1) / 2;
        if (matrix[mi][mj] == target) {
            return true;
        }
        if (matrix[mi][mj] > target) {
            return searchMatrix(matrix, target, i1, j1, i2, mj - 1) || searchMatrix(matrix, target, i1, mj, mi - 1, j2);
        }
        return searchMatrix(matrix, target, mi+1, j1, i2, j2) || searchMatrix(matrix, target, i1, mj + 1, mi, j2);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
}
