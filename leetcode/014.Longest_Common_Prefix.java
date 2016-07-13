public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(true) {
            boolean stop = false;
            Character common = null;
            for (String str : strs) {
                if (idx >= str.length()) {
                    stop = true;
                    break;
                }
                char c = str.charAt(idx);
                if (common == null) {
                    common = c;
                } else {
                    if (c != common) {
                        stop = true;
                        break;
                    }
                }
            }
            if (stop) {
                break;
            }
            sb.append(common);
            idx++;
        }
        return sb.toString();
    }
}
