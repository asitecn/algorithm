public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if (i >= 10) {
                sb.deleteCharAt(0);
            }
            sb.append(s.charAt(i));
            if (i >= 9) {
                String str = sb.toString();
                if (map.containsKey(str)) {
                    if (!map.get(str)) {
                        res.add(str);
                        map.put(str, true);
                    }
                } else {
                    map.put(str, false);
                }
            }
        }
        return res;
    }
}
