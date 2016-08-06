public class Solution {
    
    public void restoreIpAddresses(List<String> res, String path, String s, int pos, int parts) {
        if (pos == s.length()) {
            if (parts == 4) {
                res.add(path.substring(1));
            }
            return;
        }
        restoreIpAddresses(res, path + "." + s.charAt(pos), s, pos + 1, parts + 1);
        if (s.charAt(pos) == '0') {
            return;
        }
        if (pos + 2 <= s.length()) {
            restoreIpAddresses(res, path + "." + s.substring(pos, pos + 2), s, pos + 2, parts + 1);
        }
        if (pos + 3 <= s.length()) {
            Integer val = Integer.parseInt(s.substring(pos, pos + 3));
            if (val <= 255) {
                restoreIpAddresses(res, path + "." + val, s, pos + 3, parts + 1);
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        // Given "25525511135",
        // return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
        // x|x|x|x
        List<String> res = new ArrayList<String>();
        if (s.length() >= 13) {
            return res;
        }
        restoreIpAddresses(res, "", s, 0, 0);
        return res;
    }
}
