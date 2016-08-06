public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        if (!dp[s.length()]) {
            return new ArrayList<>();
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for(int i = 0; i <= s.length(); i++) {
            map.put(i, new ArrayList<>());
        }
        map.get(0).add("");

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j]) {
                    String sub = s.substring(j, i);
                    if (wordDict.contains(sub)) {
                        for(String str : map.get(j)) {
                            map.get(i).add(str + (str.isEmpty() ? "" : " ") + sub);
                        }
                    }
                }
            }
        }
        return map.get(s.length());
    }
}
