public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            list.add(i+1);
        }
        
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            if (i == 0) {
                f[0] = 1;
            } else {
                f[i] = f[i-1]*i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(list.size() > 0 & k > 0) {
            n = list.size();
            int idx = (k - 1)/f[n-1];
            sb.append(list.get(idx));
            list.remove(idx);
            k -= idx*f[n-1];
        }
        return sb.toString();
    }
}
