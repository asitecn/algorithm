public class Solution {
    public void spiralOrder(List<Integer> results, int[][] matrix, int is, int js, int ie, int je) {
        if (is == ie) {
            for (int j = js; j <= je; j++) {
                results.add(matrix[is][j]);
            }
            return;
        } 
        if (js == je) {
            for (int i = is; i <= ie; i++) {
                results.add(matrix[i][js]);
            }
            return;
        }
        if (is > ie || js > je) {
            return;
        }
        for (int j = js; j < je; j++) {
            results.add(matrix[is][j]);
        }
        for (int i = is; i < ie; i++) {
            results.add(matrix[i][je]);
        }
        for (int j = je; j > js; j--) {
            results.add(matrix[ie][j]);
        }
        for (int i = ie; i > is; i--) {
            results.add(matrix[i][js]);
        }
        spiralOrder(results, matrix, is + 1, js + 1, ie - 1, je - 1);
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        // [
        //  [ 1, 2, 3 ],
        //  [ 4, 5, 6 ],
        //  [ 7, 8, 9 ]
        // ]        
        
        List<Integer> results = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return results;
        }
        spiralOrder(results, matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
        return results;
    }
}
