public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for(int k = 1; k < n; k++) {
            Character c = null;
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if (c == null) {
                    c = s.charAt(i);
                    count = 1;
                } else if (c == s.charAt(i)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(c);
                    c = s.charAt(i);
                    count = 1;
                }
                if (i == s.length() - 1) {
                    sb.append(count);
                    sb.append(c);
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
