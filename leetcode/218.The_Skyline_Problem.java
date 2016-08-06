public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        
        // x, flag, id
        int[][] lines = new int[buildings.length<<1][3];
        for(int i = 0; i < buildings.length; i++) {
            lines[i<<1] = new int[]{buildings[i][0], 0, buildings[i][2]};
            lines[(i<<1)+1] = new int[]{buildings[i][1], 1, buildings[i][2]};
        }
        
        Arrays.sort(lines, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            if (a[1] == 0) {
                return b[2] - a[2];
            }
            return a[2] - b[2];
        });
        
        Queue<Integer> queue = new PriorityQueue<>( (a, b) -> {return b - a;} );
        
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < lines.length; i++) {
            int[] line = lines[i];
            int axis = line[0];
            int flag = line[1];
            int h = line[2];

            int prev = (queue.isEmpty() ? 0 : queue.peek());
            if (flag == 0) {
                queue.offer(h);
            } else {
                queue.remove(h);
            }
            int cur = (queue.isEmpty() ? 0 : queue.peek());
            if (cur != prev) {
                res.add(new int[]{axis, cur});
            }
        }
        
        return res;
    }
}
