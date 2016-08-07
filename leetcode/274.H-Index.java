public class Solution {
    public int hIndex(int[] citations) {
        /* sort 
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
        */
        
        // bucket sort
        int[] total = new int[citations.length + 1];
        for(int i = 0; i < citations.length; i++) {
            total[Math.min(citations.length, citations[i])]++;
        }
        int sum = 0;
        for(int i = total.length - 1; i > 0; i--) {
            sum += total[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
