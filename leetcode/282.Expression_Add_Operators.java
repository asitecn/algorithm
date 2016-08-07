public class Solution {
    public void addOperators(List<String> res, String path, String num, int target, long sum, int pos, long multi) {
        if (pos == num.length()) {
            if ((long)target == sum) {
                res.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if (i > pos && num.charAt(pos) == '0') {
                break;
            }
            long val = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                addOperators(res, "" + val, num, target, val, i + 1, val);
            } else {
                addOperators(res, path + "+" + val, num, target, sum + val, i + 1, val);
                addOperators(res, path + "-" + val, num, target, sum - val, i + 1, -val);
                addOperators(res, path + "*" + val, num, target, sum - multi + multi * val, i + 1, multi*val);
            }
        }
    }
    
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        addOperators(res, "", num, target, 0, 0, 1L);
        return res;
    }
}
