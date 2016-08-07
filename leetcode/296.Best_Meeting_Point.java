public class Solution {
    public int minDistance(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        int sum = 0;
        while(i < j) {
            sum += (list.get(j--) - list.get(i++));
        }
        return sum;
    }
    
    public int minTotalDistance(int[][] grid) {
        List<Integer> lx = new ArrayList<Integer>();
        List<Integer> ly = new ArrayList<Integer>();

        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    lx.add(i);
                }
            }
        }
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    ly.add(j);
                }
            }
        }
        
        return minDistance(lx) + minDistance(ly);
    }
}
