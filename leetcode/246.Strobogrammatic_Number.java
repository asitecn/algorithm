public class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0; 
        int j = num.length() - 1;
        while (i <= j) {
            char ci = num.charAt(i);
            char cj = num.charAt(j);
            if (ci != cj) {
                if (!((ci == '6' && cj == '9') || (ci == '9' && cj == '6'))) {
                    return false;
                }
            } else {
                if (ci != '0' && ci != '1' && ci != '8') {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
}
