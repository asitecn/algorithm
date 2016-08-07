public class Solution {
    
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean isEqual = word1.equals(word2);
        
        int idx1 = -1;
        int idx2 = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isEqual) {
                if (word.equals(word1)) {
                    if (idx1 != -1) {
                        min = Math.min(min, i - idx1);
                    }
                    idx1 = i;
                }
            } else {
                if (word.equals(word1)) {
                    idx1 = i;
                    if (idx2 != -1) {
                        min = Math.min(min, i - idx2);
                    }
                } else if (word.equals(word2)) {
                    idx2 = i;
                    if (idx1 != -1) {
                        min = Math.min(min, i - idx1);
                    }
                }
            }
        }
        
        return min;
    }
}
