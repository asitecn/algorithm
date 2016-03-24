public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        String[] strs = new String[numRows];
        for(int i = 0; i < strs.length; i++) {
            strs[i] = "";
        }
        int counter = 0;
        boolean down = true;
        for(int i = 0; i < s.length(); i++) {
            strs[counter] += s.charAt(i);
            if (down) {
                if (counter < numRows - 1) {
                    counter++;
                } else {
                    counter--;
                    down = false;
                }
            } else {
                if (counter > 0) {
                    counter--;
                } else {
                    counter++;
                    down = true;
                }
            }
        }
        
        String output = "";
        for(int i = 0; i < strs.length; i++) {
            output += strs[i];
        }
        return output;
    }
}
