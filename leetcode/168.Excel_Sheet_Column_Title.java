public class Solution {
    public String convertToTitle(int n) {
        /*
            1 -> A
            2 -> B
            3 -> C
            ...
            26 -> Z
            27 -> AA
            28 -> AB 
        */
        
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            sb.insert(0, (char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
