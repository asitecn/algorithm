public class SolveSudoku {
    
    private int m, n;

    public char[][] saveCopy(char[][] visited) {
        char[][] copied = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                copied[i][j] = visited[i][j];
            }
        }
        return copied;
    }

    
    public boolean isValid(char[][] board, int i, int j, char c) {
        // check horizontal
        for(int k = 0; k < n; k++) {
            if (board[i][k] == c) {
                return false;
            }
        }
        // check vertical
        for(int k = 0; k < m; k++) {
            if (board[k][j] == c) {
                return false;
            }
        }
        // check local box
        int is = (i/3)*3;
        int js = (j/3)*3;
        for(int k1 = 0; k1 < 3; k1++) {
            for(int k2 = 0; k2 < 3; k2++) {
                if (board[is+k1][js+k2] == c) {
                    return false;
                }
            }
        }        
        return true;
    }


    public boolean solveSudoku(char[][] board, int idx) {
        if (idx == 81) {
            System.out.println("REACHED!!");
            return true;
        }
        int i = idx/9;
        int j = idx%9;
//        System.out.println("i=" + i + ",j=" + j);
        if (board[i][j] == '.') {
            for(char k = '1'; k <= '9'; k++) {
                if (isValid(board, i, j, k)) {
                    //System.out.println("valid + " + k);
                    board[i][j] = k;
                    if (solveSudoku(board, idx+1)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
        } else {
            return solveSudoku(board, idx+1);
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        m = board.length;
        n = board[0].length;
        solveSudoku(board, 0);
    }

    public char[][] convert(String[] sarr) {
        char[][] result = new char[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < sarr[i].length(); j++) {
                result[i][j] = sarr[i].charAt(j);
            }
        }
        return result;
    }

    public void print(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print(",");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SolveSudoku s = new SolveSudoku();
        char[][] board = s.convert(new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."});
        s.print(board);
        s.solveSudoku(board);
        s.print(board);
    }
}
