public class Solution {
    
    public String signature(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String s = signature(strs[i]);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> me : map.entrySet()) {
            res.add(me.getValue());
        }
        return res;
    }
}
