public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new LinkedList<String>();
        char[] chars = s.toCharArray();
        for(int i = 1; i < chars.length; i++) {
            if (chars[i] == '+' && chars[i-1] == '+') {
                chars[i] = '-';
                chars[i-1] = '-';
                result.add(new String(chars));
                chars[i] = '+';
                chars[i-1] = '+';
            }
        }
        return result;
    }
}
