public class KMP {

    /*
# | String | P(#) | Longest matching prefix-suffix
0 | "a" | 0 | ""
1 | "ab" | 0 | ""
2 | "aba" | 1 | "a" -- a b a
3 | "abab" | 2 | "ab" -- ab ab
4 | "ababa" | 3 | "aba" -- ab a ba
5 | "ababac" | 0 | ""
6 | "ababaca" | 1 | "a" -- a babac a
     */

    public int[] prefixFunctionMine(String s) {
        int[] pf = new int[s.length()];
        int j = 0;
        for(int i = 1; i < pf.length; i++) {
            if (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = 0;
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pf[i] = j;
        }
        return pf;
    }


    public int[] prefixFunction(String s) {
        int[] pf = new int[s.length()];
        int j = 0;
        for(int i = 1; i < pf.length; i++) {
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pf[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            pf[i] = j;
        }
        return pf;
    }

    public boolean isSubstring(String needle, String hayback) {

        for(int i = 0; i < needle.length(); i++) {
            System.out.print(needle.charAt(i));
        }
        System.out.println();

        {        
            int[] prefix = prefixFunction(needle);
            for(int i = 0; i < prefix.length; i++) {
                System.out.print(prefix[i]);
            }
            System.out.println();
        }

        {        
            int[] prefix = prefixFunctionMine(needle);
            for(int i = 0; i < prefix.length; i++) {
                System.out.print(prefix[i]);
            }
            System.out.println();
        }


        return true;
    }

    public int match(String text, String pattern) {
        if (text.length() == 0) {
            return 0;
        }
        int[] p = prefixFunction(pattern);

        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
                j = p[j - 1];
            }
            if (pattern.charAt(j) == text.charAt(i)) { 
                j++; 
            }
            if (j == pattern.length()) {
                // int matchPoint = i - pattern.length() + 1;
                return (i - pattern.length() + 1);
            }
        }
        return -1;
    }

    public int kmpMatcher(String s, String pattern) {
        int m = pattern.length();
        if (m == 0) {
            return 0;
        }
        int[] p = prefixFunction(pattern);
        for (int i = 0, k = 0; i < s.length(); i++)
            for (; ; k = p[k - 1]) {
                if (pattern.charAt(k) == s.charAt(i)) {
                    if (++k == m) {
                        return i + 1 - m;
                    }
                    break;
                }
                if (k == 0) {
                    break;
                }
            }
        return -1;
    }

    public static void main(String args[]) {
        KMP kmp = new KMP();
        //        kmp.isSubstring("ababaaaba","b");
        //        kmp.isSubstring("ababcccabababcccabab","b");
        //        kmp.isSubstring("abcdabcabcd","b");
        //        kmp.isSubstring("abcdabccabcd","b");
        //        kmp.isSubstring("abcdabcbcbcd","b");
        //        kmp.isSubstring("ababcabababcabab","b");
        kmp.isSubstring("ababcabababc","b");
        kmp.isSubstring("ababcababababc","b");
        kmp.isSubstring("abcdab abcdabcdabde","abcdabd");
        System.out.println(kmp.kmpMatcher("ababcababababc", "ababab"));
        System.out.println(kmp.match("ababcababababc", "ababab"));
    }
}
