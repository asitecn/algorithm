public class NumMatrix {

    int[][] sums;

    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            sums[i] = new int[matrix[i].length];
            for(int j = 0; j < matrix[i].length; j++) {
                sums[i][j] = matrix[i][j] + (j == 0 ? 0 : sums[i][j-1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int row = row1; row <= row2; row++) {
            sum += (sums[row][col2] - (col1 == 0 ? 0 : sums[row][col1-1]));
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
