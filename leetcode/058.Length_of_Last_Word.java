public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean startCount = false;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (startCount) {
                if (c == ' ') {
                    break;
                } else {
                    count++;
                }
            } else {
                if (c != ' ') {
                    startCount = true;
                    count = 1;
                }
            }
        }
        return count;
    }
}
