public class Solution {
    public List<String> generatePalindromes(String s) {

    /*
     Given s = "aabb", return ["abba", "baab"].
     Given s = "abc", return []. 
     */

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        Character singleCharacter = null;
        boolean found = false;
        for(Map.Entry<Character, Integer> me : map.entrySet()) {
            if (me.getValue() % 2 == 1) {
                if (singleCharacter != null) {
                    return res;
                }
                singleCharacter = me.getKey();
            }
            for(int i = 0; i < me.getValue() / 2; i++) {
                sb.append(me.getKey());
            }
        }

        String candidate = sb.toString();
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[candidate.length()];
        generateUniquePermutations(list, "", candidate, 0, visited);
        for(String str : list) {
            res.add(str + (singleCharacter == null ? "" : "" + singleCharacter) + (new StringBuffer(str)).reverse().toString());
        }
        return res;
    }
    
    
    public void generateUniquePermutations(List<String> list, String path, String candidate, int pos, boolean[] visited) {
        if (pos == candidate.length()) {
            list.add(path);
            return;
        }
        for(int i = 0; i < candidate.length(); i++) {
            if (visited[i] || (i > 0 && candidate.charAt(i) == candidate.charAt(i-1) && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            generateUniquePermutations(list, path + candidate.charAt(i), candidate, pos+1, visited);
            visited[i] = false;
        }
    }
}
