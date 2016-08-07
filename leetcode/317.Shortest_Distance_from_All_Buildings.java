public class Solution {

    public int bfs(int[][] grid, int i, int j, boolean[][] visited, int numBuildings) {
        
        int total = 0;
        int len = 1;
        int buildings = 0;
        Queue<int[]> q1 = new LinkedList<int[]>();
        q1.add(new int[]{i, j});
        Queue<int[]> q2 = new LinkedList<int[]>();
        while(!q1.isEmpty()) {
            int[] point = q1.remove();
            // up
            if (point[0] > 0) {
                int[] dot = new int[]{point[0] - 1, point[1]};
                if (!visited[dot[0]][dot[1]]) {
                    if (grid[dot[0]][dot[1]] == 1) {
                        total += len;
                        buildings++;
                    } else if (grid[dot[0]][dot[1]] == 0) {
                        q2.add(dot);
                    }
                    visited[dot[0]][dot[1]] = true;
                }
            }
            // down
            if (point[0] < grid.length - 1) {
                int[] dot = new int[]{point[0] + 1, point[1]};
                if (!visited[dot[0]][dot[1]]) {
                    if (grid[dot[0]][dot[1]] == 1) {
                        total += len;
                        buildings++;
                    } else if (grid[dot[0]][dot[1]] == 0) {
                        q2.add(dot);
                    }
                    visited[dot[0]][dot[1]] = true;
                }
            }
            // left
            if (point[1] > 0) {
                int[] dot = new int[]{point[0], point[1] - 1};
                if (!visited[dot[0]][dot[1]]) {
                    if (grid[dot[0]][dot[1]] == 1) {
                        total += len;
                        buildings++;
                    } else if (grid[dot[0]][dot[1]] == 0) {
                        q2.add(dot);
                    }
                    visited[dot[0]][dot[1]] = true;
                }
            }
            // right
            if (point[1] < grid[0].length - 1) {
                int[] dot = new int[]{point[0], point[1] + 1};
                if (!visited[dot[0]][dot[1]]) {
                    if (grid[dot[0]][dot[1]] == 1) {
                        total += len;
                        buildings++;
                    } else if (grid[dot[0]][dot[1]] == 0) {
                        q2.add(dot);
                    }
                    visited[dot[0]][dot[1]] = true;
                }
            }
            
            if (buildings == numBuildings) {
                break;
            }

            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;
                len++;
            }
        }
        return (buildings == numBuildings? total : -1);
    }
    
    public int shortestDistance(int[][] grid) {
        int numBuildings = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    numBuildings++;
                }
            }
        }
        
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    visited[i][j] = true;
                    int result = bfs(grid, i, j, visited, numBuildings);
                    if (result != -1) {
                        shortest = Math.min(shortest, result);
                    }
                }
            }
        }
        return (shortest == Integer.MAX_VALUE ? -1 : shortest);
    }
}
