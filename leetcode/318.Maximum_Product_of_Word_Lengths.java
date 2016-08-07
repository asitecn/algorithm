public class Solution {
    public int maxProduct(String[] words) {

    /*
        Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
        Return 16
        The two words can be "abcw", "xtfn".
    */
    
        int[] bits = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            int bit = 0;
            for(int j = 0; j < word.length(); j++) {
                bit |= (1 << (word.charAt(j) - 'a' + 1));
            }
            bits[i] = bit;
        }
        
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if (i != j && ((bits[i] & bits[j]) == 0)) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        
        return max;
    }
}
