public class KMPTest {

    public int[] pf(String str) {
        int[] pf = new int[str.length()];
        pf[0] = 0;
        int j = 0;
        for(int i = 1; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pf[j-1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            pf[i] = j;
        }
        return pf;
    }

    public int match(String str, String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return 0;
        }
        int[] pf = pf(pattern);
        for(int i = 0, j = 0; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != pattern.charAt(j)) {
                j = pf[j-1];
            }
            if (str.charAt(i) == pattern.charAt(j)) {
                if (++j==pattern.length()) {
                    return (i - pattern.length() + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        KMPTest kmp = new KMPTest();
        System.out.println(kmp.match("abcdab abcdabd", "abcdabd"));
    }
}
