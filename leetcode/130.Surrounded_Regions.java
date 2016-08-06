// Solution 1 - dfs
public class Solution {
    
    public void dfs(char[][] board, int i, int j) {
        board[i][j] = 'Q';
        if (i > 1 && board[i-1][j] == 'O') {
            dfs(board, i-1, j);
        }
        if (j > 1 && board[i][j-1] == 'O') {
            dfs(board, i, j-1);
        }
        if (i < board.length-2 && board[i+1][j] == 'O') {
            dfs(board, i+1, j);
        }
        if (j < board[0].length-2 && board[i][j+1] == 'O') {
            dfs(board, i, j+1);
        }
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        for(int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
        }
        
        for(int i = 1; i < m - 1; i++) {
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for(int j = n-1; j > 0; j--) {
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for(int i = m - 1; i > 0; i--) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}


// Solution 2 - union-find
public class Solution {
    
    int[] father;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0)  {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        father = new int[m*n + 1];
        for(int i = 0; i < father.length; i++) {
            father[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (j < n - 1 && board[i][j+1] == 'O') {
                        union(i*n+j, i*n+j+1);
                    }
                    if (i < m - 1 && board[i+1][j] == 'O') {
                        union(i*n+j, (i+1)*n+j);
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                union(i*n, father.length-1);
            }
            if (board[i][n-1] == 'O') {
                union(i*n + n - 1, father.length-1);
            }
        }

        for(int j = 1; j < n-1; j++) {
            if (board[0][j] == 'O') {
                union(j, father.length-1);
            }
            if (board[m-1][j] == 'O') {
                union((m-1)*n + j, father.length-1);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    //System.out.println(find(i*n+j));
                    if (find(i*n+j) != father.length - 1) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    
    
    int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    
    void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
}
