public class Dungeon {

    // [3,-20,30],[-3,4,0]

    public static void main(String args[]) {
        Dungeon d = new Dungeon();

        int[][] dungeon = new int[][]{
            {1,-3,3},
            {0,-2,0},
            {-3,-3,-3}
        };
        System.out.println(d.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return Integer.MAX_VALUE;
        }
        int m = dungeon.length, n = dungeon[0].length;
        int[][] min = new int[m][n];
        int[][] hp = new int[m][n];
        min[0][0] = 1 - Math.min(dungeon[0][0], 0);
        hp[0][0] = 1 + Math.max(dungeon[0][0], 0);
        System.out.println(min[0][0]);
        System.out.println(hp[0][0]);
        for(int i = 1; i < m; i++) {
//                System.out.println("i=" + i + ", i am here3.");
            if (hp[i-1][0] + dungeon[i][0] <= 0) {
                min[i][0] = min[i-1][0] + 1 - (hp[i-1][0] + dungeon[i][0]);
                hp[i][0] = 1;
            } else {
                min[i][0] = min[i-1][0];
                hp[i][0] = hp[i-1][0] + dungeon[i][0];
            }
            int j = 0;
            System.out.println("i=" + i + ",j=" + j + ",min[i][j]=" + min[i][j] + ",hp[i][j]=" + hp[i][j]);
        }
//        System.out.println(min[1][0] + "\t" + hp[1][0]);
        for(int j = 1; j < n; j++) {
 //               System.out.println("i am here2.");
            if (hp[0][j-1] + dungeon[0][j] <= 0) {
                min[0][j] = min[0][j-1] + 1 - (hp[0][j-1] + dungeon[0][j]);
                hp[0][j] = 1;
            } else {
                min[0][j] = min[0][j-1];
                hp[0][j] = hp[0][j-1] + dungeon[0][j];
            }
             int i = 0;
            System.out.println("i=" + i + ",j=" + j + ",min[i][j]=" + min[i][j] + ",hp[i][j]=" + hp[i][j]);
       }
//        System.out.println(min[0][1] + "\t" + hp[0][1]);
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
//                System.out.println("i am here.");
                int min1, min2, hp1, hp2;
                if (hp[i-1][j] + dungeon[i][j] <= 0) {
                    min1 = min[i-1][j] + 1 - (hp[i-1][j] + dungeon[i][j]);
                    hp1 = 1;
                } else {
                    min1 = min[i-1][j];
                    hp1 = hp[i-1][j] + dungeon[i][j];
                }  
                if (hp[i][j-1] + dungeon[i][j] <= 0) {
                    min2 = min[i][j-1] + 1 - (hp[i][j-1] + dungeon[i][j]);
                    hp2 = 1;
                } else {
                    min2 = min[i][j-1];
                    hp2 = hp[i][j-1] + dungeon[i][j];
                }
                if (min1 == min2) {
                    min[i][j] = min1;
                    hp[i][j] = Math.max(hp1, hp2);
                } else if (min1 < min2) {
                    min[i][j] = min1;
                    hp[i][j] = hp1;
                } else {
                    min[i][j] = min2;
                    hp[i][j] = hp2;
                }
                System.out.println("i=" + i + ",j=" + j + ",min[i][j]=" + min[i][j] + ",hp[i][j]=" + hp[i][j]);
            }
        }
        return min[m-1][n-1];
    }
}
