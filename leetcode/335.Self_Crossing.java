public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3) {
            return false;
        }
        
        boolean inside = false;
        for(int i = 3; i < x.length; i++) {

            if (x[i-1] > x[i-3]) {
                // still outside
                continue;
            }

            if (inside) {
                if (x[i] >= x[i-2]) {
                    return true;
                }
                continue;
            }
            
            if (x[i] >= x[i-2] || 
                (x[i-1] + (i >= 5 ? x[i-5] : 0) >= x[i-3] && x[i] + (i >= 4 ? x[i-4] : 0) >= x[i-2])) {
                    return true;
            }
            inside = true;
        }
        return false;
    }
}
