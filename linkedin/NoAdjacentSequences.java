public class NoAdjacentSequences {

/*
3. There is a particular sequence only uses the numbers 1, 2, 3, 4 and no two adjacent numbers are the same.
Write a program that given n1 1s, n2 2s, n3 3s, n4 4s will output the number of such sequences using all these numbers.
*/

    public int seq(int[] arr) {
        // 1, 1, 2, 3, 3, 3, 4
        int n1 = arr[0];
        int n2 = arr[1];
        int n3 = arr[2];
        int n4 = arr[3];
        int[][][][] d1 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d2 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d3 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d4 = new int[n1+1][n2+1][n3+1][n4+1];
        d1[1][0][0][0]=1;
        d2[0][1][0][0]=1;
        d3[0][0][1][0]=1;
        d4[0][0][0][1]=1;
        for(int i=0;i<=arr[0];i++){
            for(int j=0;j<=arr[1];j++){
                for(int k=0;k<=arr[2];k++){
                    for(int l=0;l<=arr[3];l++){
                        if (i + j + k + l > 1) {
                            if(i > 0) {
                                d1[i][j][k][l]=d2[i-1][j][k][l]+d3[i-1][j][k][l]+d4[i-1][j][k][l];
                            }
                            if(j > 0) {
                                d2[i][j][k][l]=d1[i][j-1][k][l]+d3[i][j-1][k][l]+d4[i][j-1][k][l];
                            }
                            if(k > 0) {
                                d3[i][j][k][l]=d2[i][j][k-1][l]+d1[i][j][k-1][l]+d4[i][j][k-1][l];
                            }
                            if(l > 0) {
                                d4[i][j][k][l]=d2[i][j][k][l-1]+d3[i][j][k][l-1]+d1[i][j][k][l-1];
                            }
                        }
                    }
                 }
            }
        }
        return d1[n1][n2][n3][n4]  
                + d2[n1][n2][n3][n4]
                + d3[n1][n2][n3][n4]
                + d4[n1][n2][n3][n4];
    }



    public static void main(String[] args) {
        NoAdjacentSequences solution = new NoAdjacentSequences();
        int[] arr = new int[]{1, 1, 1, 1};
        System.out.println(solution.seq(arr));
    }
}
