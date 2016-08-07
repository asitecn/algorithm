public class Solution {
    /*
        "()())()" -> ["()()()", "(())()"]
        "(a)())()" -> ["(a)()()", "(a())()"]
        ")(" -> [""]
    */
    
    boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return (count == 0);
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        if (isValid(s)) {
            list.add(s);
            return list;
        }

        Set<String> res = new HashSet<>();
        
        Set<String> cur = new HashSet<>();
        cur.add(s);
        Set<String> next = new HashSet<>();

        while(res.isEmpty() && !cur.isEmpty()) {
            for(String curStr : cur) {
                for(int i = 0; i < curStr.length(); i++) {
                    if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                        String str = curStr.substring(0, i) + curStr.substring(i+1);
                        if (!next.contains(str)) {
                            if (isValid(str)) {
                                res.add(str);
                            }
                            next.add(str);
                        }
                    }
                }
            }
            cur = next;
            next = new HashSet<>();
        }
        
        return new ArrayList<String>(res);
    }
}
