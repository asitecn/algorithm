public class Solution {

/*
        Input: "2-1-1".
        
        ((2-1)-1) = 0
        (2-(1-1)) = 2
        
        Output: [0, 2]
*/

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(Integer l : left) {
                    for(Integer r : right) {
                        res.add(c == '+' ? l + r : (c == '-' ? l - r : l*r));
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}
