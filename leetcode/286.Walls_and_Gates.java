public class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q1 = new LinkedList<int[]>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    q1.offer(new int[]{i, j});
                }
            }
        }
        
        Queue<int[]> q2 = new LinkedList<int[]>();
        int depth = 1;
        while(!q1.isEmpty()) {
            int[] node = q1.poll();
            int i = node[0];
            int j = node[1];
            // up
            if (i > 0 && rooms[i-1][j] > depth) {
                rooms[i-1][j] = depth;
                q2.offer(new int[]{i-1, j});
            }
            // down
            if (i < rooms.length - 1 && rooms[i+1][j] > depth) {
                rooms[i+1][j] = depth;
                q2.offer(new int[]{i+1, j});
            }
            // left
            if (j > 0 && rooms[i][j-1] > depth) {
                rooms[i][j-1] = depth;
                q2.offer(new int[]{i, j-1});
            }
            // right
            if (j < rooms[i].length - 1 && rooms[i][j+1] > depth) {
                rooms[i][j+1] = depth;
                q2.offer(new int[]{i, j+1});
            }
            if (q1.isEmpty()) {
                Queue<int[]> temp = q1;
                q1 = q2;
                q2 = temp;
                depth++;
            }
        }
    }
}
