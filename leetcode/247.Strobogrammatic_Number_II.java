public class Solution {
    public List<String> findStrobogrammatic(int n, int k) {
        if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        if (n == 2) {
            if (n == k) {
                return new ArrayList<String>(Arrays.asList("11", "69", "88", "96"));
            } else {
                return new ArrayList<String>(Arrays.asList("11", "69", "88", "96", "00"));
            }
        }
        List<String> res = new ArrayList<>();
        List<String> prev = findStrobogrammatic(n-2, n);
        for(String str : prev) {
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
            if (n != k) {
                res.add("0" + str + "0");
            }
        }
        return res;
    }
    
    public List<String> findStrobogrammatic(int n) {
        return findStrobogrammatic(n, n);
    }
}
