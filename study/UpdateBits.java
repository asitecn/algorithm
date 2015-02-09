//You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to set all bits between i and j in N equal to M (e.g., M becomes a substring of N located at i and starting at j).
//EXAMPLE:
//Input: N = 10000000000, M = 10101, i = 2, j = 6
//Output: N = 10001010100

public class UpdateBits {
    public int updateBits(int M, int N, int i, int j)  {
        int max = ~0;
        int mask = (max - (1<<j-1)) | (1<<i-1);
        return (N & mask) | (M << i);
    }

    public static void main(String args[]) {
        UpdateBits ub = new UpdateBits();
        int N = 1 << 10;
        int M = 21;
        System.out.println(ub.updateBits(M, N, 2, 6));
    }
}
