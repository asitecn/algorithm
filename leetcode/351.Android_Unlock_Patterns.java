public class Solution {
    
    public boolean isCrossing(boolean[][] visited, int curX, int curY, int nextX, int nextY) {
        if (curX == nextX) {
            if (Math.abs(curY - nextY) < 2) {
                return false;
            }
            return !visited[curX][(curY + nextY) / 2];
        }
        if (curY == nextY) {
            if (Math.abs(curX - nextX) < 2) {
                return false;
            }
            return !visited[(curX + nextX) / 2][curY];
        }
        if (curX == curY && nextX == nextY) {
            if (Math.abs(curY - nextY) < 2) {
                return false;
            }
            return !visited[1][1];
        }
        if (curX + curY == 2 && nextX + nextY == 2) {
            if (Math.abs(curY - nextY) < 2) {
                return false;
            }
            return !visited[1][1];
        }
        return false;
    }
    
    int count;
    public void numberOfPatterns(boolean[][] visited, int i, int j, int c, int k) {
        if (c == k) {
            count++;
            return;
        }
        visited[i][j] = true;
        int[] d = new int[]{-2, -1, 0, 1, 2};
        for(int row = 0; row < d.length; row++) {
            for(int col = 0; col < d.length; col++) {
                if (d[row] == 0 && d[col] == 0) {
                    continue;
                }
                int nextRow = i + d[row];
                int nextCol = j + d[col];
                if (nextRow < 0 || nextRow > 2 || nextCol < 0 || nextCol > 2 
                    || visited[nextRow][nextCol] || isCrossing(visited, i, j, nextRow, nextCol)) {
                    continue;
                }
                numberOfPatterns(visited, nextRow, nextCol, c+1, k);
            }
        }
        visited[i][j] = false;
    }
    
    public int numberOfPatterns(int m, int n) {
        count = 0;
                    boolean[][] visited = new boolean[3][3];
        for(int k = m; k <= n; k++) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    numberOfPatterns(visited, i, j, 1, k);
                }
            }
        }
        return count;
    }
}
