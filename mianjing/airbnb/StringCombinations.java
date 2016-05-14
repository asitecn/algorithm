// https://www.glassdoor.com/Interview/Airbnb-Software-Engineer-Interview-Questions-EI_IE391850.0,6_KO7,24_IP5.htm
// 1. find all the combinations of a string in lowercase and uppercase. For example, string "ab" -&gt; "ab", "Ab", "aB", "AB". So, you will have 2^n (n = number of chars in the string) output strings. The goal is for you to test each of these string and see if it match a hidden string.

import java.util.*;
public class StringCombinations {

    public void combination(List<String> res, String path, String s, int pos) {
        if (pos == s.length()) {
            res.add(path);
            return;
        }
        char c = s.charAt(pos);
        combination(res, path + c, s, pos + 1);
        combination(res, path + (char)(c - 'a' + 'A'), s, pos + 1);
    }

    public List<String> combination(String s) {
        List<String> res = new ArrayList<>();
        combination(res, "", s, 0);
        return res;
    }

    public static void main(String[] args) {
        StringCombinations com = new StringCombinations();
        List<String> l = com.combination("ab");
        for(String s : l) {
            System.out.println(s);
        }
    }
}
