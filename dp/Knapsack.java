public class Knapsack {


    public int[] find(int[] wt, int[] val, int capacity) {
        int n = wt.length;
        int W = capacity;

        int[][] K = new int[n+1][W+1];
        int[] result = new int[n];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i==0 || w==0) {
                    K[i][w] = 0;
                } else if (wt[i-1] <= w) {  // still have capacity
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }        

        System.out.println(K[n][W]);
//        return new int[]{1, 1, 1, 1, 0, 1, 0, 0, 0, 0};
        return result;
//        return K[n][W];
    }

    public boolean compare(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        System.out.print("Expect:\t");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.print("Actual:\t");
        for(int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Knapsack ks = new Knapsack();
        {
            int[] weights = new int[]{23,31,29,44,53,38,63,85,89,82};
            int[] profits = new int[]{92,57,49,68,60,43,67,84,87,72};
            int capacity = 165;
            int[] expected = new int[]{1, 1, 1, 1, 0, 1, 0, 0, 0, 0};
            int[] result = ks.find(weights, profits, capacity);
            System.out.println(ks.compare(expected, result));
        }
    }

}
