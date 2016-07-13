public class Solution {
    
    public void addResult(List<List<String>> results, char[][] board, int n) {
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            result.add(sb.toString());
        }
        results.add(result);
    }
    
    public void solveNQueens(List<List<String>> results, char[][] board, int i, int n) {
        if (i == n) {
            addResult(results, board, n);
            return;
        }
        
        for(int j = 0; j < n; j++) {
            // test if [i, j] can be a candidate
            boolean isValid = true;
            for(int l = 0; l < i; l++) {
                if (board[l][j] == 'Q') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                for(int l = 0; l < j; l++) {
                    if (board[i][l] == 'Q') {
                        isValid = false;
                    }
                }
            }
            if (isValid) {
                int l1 = i - 1;
                int l2 = j - 1;
                while(l1 >= 0 && l2 >= 0) {
                    if (board[l1][l2] == 'Q') {
                        isValid = false;
                        break;
                    }
                    l1--;
                    l2--;
                }
            }
            if (isValid) {
                int l1 = i - 1;
                int l2 = j + 1;
                while(l1 >= 0 && l2 < n) {
                    if (board[l1][l2] == 'Q') {
                        isValid = false;
                        break;
                    }
                    l1--;
                    l2++;
                }                
            }
            
            if (isValid) {
                board[i][j] = 'Q';
                solveNQueens(results, board, i+1, n);
                board[i][j] = '.';
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(results, board, 0, n);
        return results;
    }
}
