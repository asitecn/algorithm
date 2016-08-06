// Solution 1
public class Solution {
    public int countPrimes(int n) {
        boolean[] isMarked = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if (!isMarked[i]) {
                count++;
                for(int j = 2; j <= n / i; j++) {
                    if (j*i < n) {
                        isMarked[j*i] = true;
                    }
                }
            }
        }
        return count;
    }
}

// Solution 2
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int count = n - 2;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
          isPrime[i] = true;
        }
        for(int i = 2; i*i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for(int j = i*i; j < n; j+= i) {
                if (isPrime[j]) {
                    count--;
                }
                isPrime[j] = false;
            }
        }
        return count;
    }
}
