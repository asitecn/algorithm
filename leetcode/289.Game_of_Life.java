public class Solution {
    public void gameOfLife(int[][] board) {
        
        /*
        Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population..
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        */
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                int count = 0;
                for(int k = -1; k <= 1; k++) {
                    for(int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0) {
                            continue;
                        }
                        int x = i + k;
                        int y = j + l;
                        if (x < 0 || x >= board.length || y < 0 || y >= board[i].length) {
                            continue;
                        }
                        if ((board[x][y] & 1) == 1) {
                            count++;
                        }
                    } 
                }
                boolean islive = ((board[i][j] & 1) == 1);
                if ((islive && (count == 2 || count == 3)) || (!islive && count == 3)) {
                    board[i][j] |= 2;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
        
    }
}
