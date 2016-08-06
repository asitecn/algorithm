public class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int r0 = 1;
        int r1 = 0;
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i); 
            if (i == 0) {
                r1 = (cur != '0' ? 1 : 0);
                continue;
            }
            char prev = s.charAt(i-1);
            int r2 = (cur != '0' ? r1 : 0);
            if (prev != '0') {
                if (Integer.parseInt(s.substring(i-1, i+1)) <= 26) {
                    r2 += r0;
                }
            }
            r0 = r1;
            r1 = r2;
        }
        return r1;
    }
}
