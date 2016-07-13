public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        /*
            For example, given:
            s: "barfoothefoobarman"
            words: ["foo", "bar"]
            
            You should return the indices: [0,9].
        */
        
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.containsKey(words[i]) ? map.get(words[i]) + 1 : 1);
        }

        int len = words[0].length();
        int fullLen = len * (words.length - 1);
        for(int i = 0; i < len; i++) {
            int start = i;
            int end = i;
            Map<String, Integer> acc = new HashMap<>();
            while(end + len <= s.length()) {
                String str = s.substring(end, end + len);
                if (!map.containsKey(str)) {
                    end += len;
                    start = end;
                    acc = new HashMap<>();
                    continue;
                }
                
                acc.put(str, acc.containsKey(str) ? acc.get(str) + 1 : 1);
                while (acc.get(str) > map.get(str)) {
                    String first = s.substring(start, start + len);
                    acc.put(first, acc.get(first) - 1);
                    start += len;
                }
                
                if (end - start == fullLen) {
                    res.add(start);
                }
                end += len;
            }
        }
        
        return res;
    }
}
