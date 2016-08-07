public class Solution {
    
    // ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
    
    public List<String> generateAbbreviations(String word, int pos) {
        List<String> res = new ArrayList<>();
        if (pos == word.length()) {
            res.add("");
            return res;
        }
        
        List<String> next = generateAbbreviations(word, pos + 1);
        for(String s : next) {
            res.add("" + word.charAt(pos) + s);
            int num = 0;
            int idx = 0;
            while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                num = num*10 + (s.charAt(idx) - '0');
                idx++;
            }
            if (num == 0) {
                res.add("1" + s);
            } else {
                res.add("" + (num+1) + s.substring(idx));
            }
        }
        return res;
    }
    
    public List<String> generateAbbreviations(String word) {
        return generateAbbreviations(word, 0);
    }
}
