public class Solution {
    public boolean isNumber(String s) {
/*
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
*/
        s = s.trim();
        int num = 0;
        boolean foundNum = false;
        Map<Character, Boolean> visited = new HashMap<Character, Boolean>();
        visited.put('e', false);
        visited.put('-', false);
        visited.put('+', false);
        visited.put('.', false);
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //System.out.println(c);

            if (!(c >= '0' && c <= '9' || c == '.' || c =='e' || c == '-' || c == '+')) {
                return false;
            }

            if (c == 'e') {
                if (!foundNum) {
                    return false;
                }
                foundNum = false;
                visited.put('+', false);
                visited.put('-', false);
                visited.put('.', false);
            }
            if (c == '.') {
                if (visited.get('e')) {
                    return false;
                }
                //foundNum = true;
            }
            if (c == '-' || c == '+') {
                if (visited.get('.') || foundNum) {
                    return false;
                }
            }
            
            for(Map.Entry<Character, Boolean> me : visited.entrySet()) {
                Character ch = me.getKey();
                boolean isVisited = me.getValue();
                if (c == me.getKey()) {
                    if (isVisited) {
                        return false;
                    }
                    me.setValue(true);
                }
            }
            
            if (c >= '0' && c <= '9') {
                foundNum = true;
            }
        }

        return foundNum;
    }
}
