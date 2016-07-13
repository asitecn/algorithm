public class Solution {
    public boolean isValid(char[][] board, int i, int j, char c) {
        for(int k = 0; k < 9; k++) {
            if (board[i][k] == c) {
                return false;
            }
        }
        for(int k = 0; k < 9; k++) {
            if (board[k][j] == c) {
                return false;
            }
        }
        for(int k1 = (i/3)*3; k1 < (i/3)*3 + 3; k1++) {
            for(int k2 = (j/3)*3; k2 < (j/3)*3 + 3; k2++) {
                if (board[k1][k2] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    } 

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
