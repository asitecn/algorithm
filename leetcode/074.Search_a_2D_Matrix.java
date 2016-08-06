public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = 0;
        int j = m*n - 1;
        while(i <= j) {
            int mid = i + (j - i) / 2;
            int val = matrix[mid/n][mid%n];
            if (val == target) {
                return true;
            } else if (val < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
