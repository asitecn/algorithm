public class NumMatrix {

/* Favor read 
    int[][] sums;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        sums = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (i == 0 && j == 0) {
                    sums[i][j] = matrix[i][j];
                } else if (i == 0) {
                    sums[i][j] = sums[i][j-1] + matrix[i][j];
                } else if (j == 0) {
                    sums[i][j] = sums[i-1][j] + matrix[i][j];
                } else {
                    sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
                }
            }
        }
        this.matrix = matrix;
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        for(int i = row; i < matrix.length; i++) {
            for(int j = col; j < matrix[0].length; j++) {
                sums[i][j] += diff;
            }
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sums[row2][col2];
        }
        if (row1 == 0) {
            return sums[row2][col2] - sums[row2][col1-1];
        }
        if (col1 == 0) {
            return sums[row2][col2] - sums[row2-1][col1];
        }
        return sums[row2][col2] - sums[row2][col1-1] - sums[row1-1][col2] + sums[row1-1][col1-1];
    }
    */

    int[][] sums;
    int[][] matrix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        this.matrix = matrix;
        sums = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                sums[i][j] = (j == 0 ? 0 : sums[i][j-1]) + matrix[i][j];
            }
        }
    }   

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for(int j = col; j < matrix[row].length; j++) {
            sums[row][j] += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            sum += sums[i][col2] - (col1 == 0 ? 0 : sums[i][col1-1]);
        }
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
