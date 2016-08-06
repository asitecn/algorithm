public class Solution {
    
    public int transform(int n) {
        int sum = 0;
        while(n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n > 0) {
            if (n == 1) {
                return true;
            }
            if (visited.contains(n)) {
                break;
            }
            visited.add(n);
            n = transform(n);
        }
        return false;
    }
}
