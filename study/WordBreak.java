import java.util.*;
public class WordBreak {

    public static boolean wordBreak(String s, Set<String> dict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                dp[i][j] = dict.contains(s.substring(i,j+1));
            }
        }
        
        for(int k = 1; k < s.length(); k++) {
            for(int i = 0; i < s.length()-k; i++) {
                for(int j = i+k; j < s.length(); j++) {
			System.out.print(i +"\t" + j + "\t" + k);
                    dp[i][j] = dp[i][j] || (dp[i][i+k-1] && dp[i+k][j]);
                }
            }
        }
        
        return dp[0][s.length()-1];
    }

	public static void main(String args[]) {
		String s = "ab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		System.out.println(WordBreak.wordBreak(s, dict));
	}
}
