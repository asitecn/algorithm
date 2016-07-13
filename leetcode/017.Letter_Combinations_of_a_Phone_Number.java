public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        int idx = 0;
        for(char c = '2'; c <= '9'; c++) {
            char[] ch = new char[c == '7' || c == '9' ? 4 : 3];
            for(int i = 0; i < ch.length; i++) {
                ch[i] = (char)('a' + idx++);
            }
            map.put(c, ch);
        }
        
        if (digits.length() == 0) {
            return new LinkedList<String>();
        }
        
        return letterCombinations(digits, 0, map);
    }
    
    public List<String> letterCombinations(String digits, int pos, Map<Character, char[]> map) {
        List<String> res = new LinkedList<String>();
        if (pos == digits.length()) {
            res.add("");
            return res;
        }
        List<String> prev = letterCombinations(digits, pos + 1, map);
        for(String s : prev) {
            char[] mapped = map.get(digits.charAt(pos));
            for(char c : mapped) {
                res.add(c + s);
            }
        }
        return res;
    }
}
