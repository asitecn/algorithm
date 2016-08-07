public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int idx1 = -1;
        int idx2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word1.equals(word)) {
                idx1 = i;
                if (idx2 != -1) {
                    min = Math.min(min, i - idx2);
                }
            } else if (word2.equals(word)) {
                idx2 = i;
                if (idx1 != -1) {
                    min = Math.min(min, i - idx1);
                }
            }
        }
        return min;
    }
}
