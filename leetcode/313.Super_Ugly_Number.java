public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] indexes = new int[primes.length];
        int[] next = new int[primes.length];
        
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < indexes.length; j++) {
                next[j] = res.get(indexes[j]) * primes[j];
                min = Math.min(min, next[j]);
            }
            for(int j = 0; j < indexes.length; j++) {
                if (next[j] == min) {
                    indexes[j]++;
                }
            }
            res.add(min);
        }
        return res.get(res.size() - 1);
    }
}
