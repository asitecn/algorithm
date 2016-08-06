public class Solution {
    public boolean exist(char[][] board, String word, int pos, int i, int j, boolean[][] visited) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean returnValue = (
            board[i][j] == word.charAt(pos) && (
                exist(board, word, pos+1, i+1, j, visited) ||
                exist(board, word, pos+1, i-1, j, visited) || 
                exist(board, word, pos+1, i, j-1, visited) || 
                exist(board, word, pos+1, i, j+1, visited)
            )
        );
        visited[i][j] = false;
        return returnValue;
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 
                || word == null || word.length() == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if (exist(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
