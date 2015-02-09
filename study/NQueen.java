import java.util.*;

public class NQueen {

    List<String[]> results = new LinkedList<>();
    int n;
    
    public String[] print(char[][] board) {
        String[] result = new String[n];
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            result[i] = sb.toString();
        }
        return result;
    }

    public boolean[][] saveCopy(boolean[][] visited) {
        boolean[][] copied = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                copied[i][j] = visited[i][j];
            }
        }
        return copied;
    }

    public void markVisited(boolean[][] visited, int i, int j) {
         for(int k = 0; k < n; k++) {
             visited[i][k] = true;
             visited[k][j] = true;
             if (i+k < n && j+k < n) {
                 visited[i+k][j+k] = true;
             }
             if (i-k >=0 && j-k >=0) {
                 visited[i-k][j-k] = true;
             }
             if (i+k <n && j-k >=0) {
                 visited[i+k][j-k] = true;
             }
             if (i-k >=0 && j+k <n) {
                 visited[i-k][j+k] = true;
             }
         }
         /*
         for(int k = 0; k < n; k++) {
             visited[(k+1)%n][(k+1)%n] = true;
         }
         for(int k = 0; k < n; k++) {
             visited[(k+1)%n][(n+k-1)%n] = true;
         }
         */
    }
    
    public void solveNQueens(int n, int idx, char[][] board, boolean[][] visited) {
        if (idx == n) {
            results.add(print(board));
            return;
        }
        for(int i = 0; i < n; i++) {
                if (visited[idx][i]) {
                    continue;
                }
                board[idx][i] = 'Q';
                boolean[][] original = saveCopy(visited);
                markVisited(visited, idx, i);
                solveNQueens(n, idx+1, board, visited);
                board[idx][i] = '.';
                visited = original;
        }
    }
    
    public List<String[]> solveNQueens(int n) {
        this.n = n;
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(n, 0, board, visited);
        return results;
    }

   	public static void main(String args[]) {
		NQueen q = new NQueen();
		List<String[]> list = q.solveNQueens(8);
		for(int i = 0; i < list.size(); i++) {
			String[] strs = list.get(i);
			for(int j = 0; j < strs.length; j++) {
				System.out.print(strs[j] + ",");
			}
			System.out.println();
		}
	}
}
