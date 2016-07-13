public class Solution {
    
    public void rotate(int[][] matrix, int is, int ie, int js, int je) {
        if (is >= ie) {
            return;
        }
        for(int i = 0; i < ie - is; i++) {
            int temp = matrix[is][js + i];
            matrix[is][js + i] = matrix[ie - i][js];
            matrix[ie - i][js] = matrix[ie][je - i];
            matrix[ie][je - i] = matrix[is + i][je];
            matrix[is + i][je] = temp;
        }
        rotate(matrix, is + 1, ie - 1, js + 1, je - 1);
    }
    
    
    public void rotate(int[][] matrix) {
        // 1 2 3 
        // 4 5 6  
        // 7 8 9
        // => 
        // 7 4 1
        // 8 5 2
        // 9 6 3
        rotate(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }
}
