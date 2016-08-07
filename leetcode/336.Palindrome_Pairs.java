public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);
                if (isPalindrome(left)) {
                    // aaabc => search for cb
                    String reversed = new StringBuffer(right).reverse().toString();
                    if (map.containsKey(reversed) && map.get(reversed) != i) {
                        List<Integer> r = new ArrayList<>();
                        r.add(map.get(reversed));
                        r.add(i);
                        res.add(r);
                    }
                }
                if (right.length() != 0 && isPalindrome(right)) {
                    // bcaaa => search for cb
                    String reversed = new StringBuffer(left).reverse().toString();
                    if (map.containsKey(reversed) && map.get(reversed) != i) {
                        List<Integer> r = new ArrayList<>();
                        r.add(i);
                        r.add(map.get(reversed));
                        res.add(r);
                    }
                }
            }
        }
        return res;
    }
}
