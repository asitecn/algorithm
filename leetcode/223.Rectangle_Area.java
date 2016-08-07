public class Solution {
    public long computeAreaLong(long A, long B, long C, long D, long E, long F, long G, long H) {
        return (G-E)*(H-F) + (C-A)*(D-B) - 
                    Math.max(Math.min(G, C) - Math.max(A, E), 0)*Math.max(Math.min(H, D) - Math.max(B, F), 0);
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (int)computeAreaLong(A, B, C, D, E, F, G, H);
    }
}
