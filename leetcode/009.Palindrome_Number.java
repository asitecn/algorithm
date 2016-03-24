public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int mirror = 0;
        while(num > 0) {
            mirror = mirror*10 + (num%10);
            num /= 10;
        }
        return (x == mirror);
    }
}
