public class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int min1 = -1;
        int min2 = -1;
        int min1Cost = 0;
        int min2Cost = 0;
        
        for(int i = 0; i < costs.length; i++) {
            int lastMin1 = min1;
            int lastMin2 = min2;
            int lastMin1Cost = min1Cost;
            int lastMin2Cost = min2Cost;
            min1 = -1;
            min2 = -1;
            for(int j = 0; j < costs[i].length; j++) {
                int cost = ((lastMin1 != j) ? lastMin1Cost : lastMin2Cost) + costs[i][j];
                //System.out.println("i=" + i + ",j=" + j + ",cost=" + cost);
                if (min1 == -1 || cost < min1Cost) {
                    min2 = min1;
                    min1 = j;

                    min2Cost = min1Cost;
                    min1Cost = cost;
                } else if (min2 == -1 || cost < min2Cost) {
                    min2 = j;
                    min2Cost = cost;
                }
            }
            //System.out.println(min1 + "\t" + min2 + "\t" + min1Cost + "\t" + min2Cost);
        }

        return min1Cost;
    }
}
