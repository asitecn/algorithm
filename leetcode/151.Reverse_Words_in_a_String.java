public class Solution {
    public String reverseWords(String s) {
        
        // Given s = "the sky is blue",
        // return "blue is sky the".
        
        StringBuilder mb = new StringBuilder();
        
        int i = 0;
        while (i < s.length()) {
            while(i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i == s.length()) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            while(i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            mb.insert(0, " " + sb.toString());
        }
        if (mb.length() > 0) {
            return mb.substring(1);
        } else {
            return mb.toString();
        }
    }
}
