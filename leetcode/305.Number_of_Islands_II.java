public class Solution {
    
    int[] father;
    private void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
    
    private int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    
    private int encode(int m, int n, int i, int j) {
        return i*n + j;
    }
    
    private void union(int m, int n, int i1, int j1, int i2, int j2) {
        int idx1 = encode(m, n, i1, j1);
        int idx2 = encode(m, n, i2, j2);
        union(idx1, idx2);
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();

        boolean[][] board = new boolean[m][n];
        father = new int[m*n];
        Arrays.fill(father, -1);
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int id = encode(m,n,i,j);
                father[id] = id;
            }
        }

        for(int k = 0; k < positions.length; k++) {
            {
                int i = positions[k][0];
                int j = positions[k][1];
                board[i][j] = true;
                if (i > 0 && board[i-1][j]) {
                    union(m, n, i, j, i-1, j);
                }
                if (i < m - 1 && board[i+1][j]) {
                    union(m, n, i, j, i+1, j);
                }
                if (j > 0 && board[i][j-1]) {
                    union(m, n, i, j, i, j-1);
                }
                if (j < n - 1 && board[i][j+1]) {
                    union(m, n, i, j, i, j+1);
                }
            }
            {
                int count = 0;
                for(int pos = 0; pos <= k; pos++) {
                    int idx = encode(m, n, positions[pos][0], positions[pos][1]);
                    if (father[idx] == idx) {
                        count++;
                    }
                }
                res.add(count);
            }
        }
        return res;
    }
}
