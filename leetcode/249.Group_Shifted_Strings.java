public class Solution {
    
    
    public List<List<String>> groupStrings(String[] strings) {
        
        Map<String, Map<Integer, Integer>> map = new HashMap<String, Map<Integer, Integer>>();
        
        for(int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int offset = s.charAt(0) - 'a';
            String signature = "";
            for(int j = 0; j < s.length(); j++) {
                signature += (char)(s.charAt(j) - offset >= 'a' ? s.charAt(j) - offset : s.charAt(j) + 26 - offset);
            }
            //System.out.println(signature + "\t" + offset);
            if (!map.containsKey(signature)) {
                map.put(signature, new TreeMap<Integer, Integer>());
            }
            Map<Integer, Integer> submap = map.get(signature);
            submap.put(offset, submap.containsKey(offset) ? submap.get(offset) + 1 : 1);
        }
        
        List<List<String>> results = new ArrayList<List<String>>();
        for(Map.Entry<String, Map<Integer, Integer>> me : map.entrySet()) {
            List<String> result = new ArrayList<String>();
            String signature = me.getKey();
            Map<Integer, Integer> submap = me.getValue();
            for(Map.Entry<Integer, Integer> me2 : submap.entrySet()) {
                int offset = me2.getKey();
                int count = me2.getValue();
                String s = "";
                for(int i = 0; i < signature.length(); i++) {
                    s += (char)(signature.charAt(i) + offset <= 'z' ? signature.charAt(i) + offset : signature.charAt(i) - 26 + offset);
                }
                //System.out.println(s);
                for(int i = 0; i < count; i++) {
                    result.add(s);
                }
            }
            results.add(result);
        }
        return results;
    }
}
