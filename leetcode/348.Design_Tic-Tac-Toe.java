public class TicTacToe {

    int[][] rowCounts;
    int[][] colCounts;
    int[][] diagnolCounts;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowCounts = new int[n][2];
        colCounts = new int[n][2];
        diagnolCounts = new int[2][2];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        player--;
        rowCounts[row][player]++;
        colCounts[col][player]++;
        if (row == col) {
            diagnolCounts[0][player]++;
        }
        if (row + col == n - 1) {
            diagnolCounts[1][player]++;
        }
        //System.out.println(diagnolCounts[0][player] + "\t" + diagnolCounts[1][player]);
        if (rowCounts[row][player] == n || colCounts[col][player] == n 
                || diagnolCounts[0][player] == n || diagnolCounts[1][player] == n) {
                    return player+1;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
