import java.util.*;

public class WordBreakII {
    
    private static class IntList extends LinkedList<Integer> {}
    
    public List<String> wordBreak(String s, Set<String> dict) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        IntList[][] connect = new IntList[s.length()][s.length()];
        // length of 1
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                dp[i][j] = dict.contains(s.substring(i,j+1));
                if (dp[i][j]) {
                    connect[i][j] = new IntList();
                    connect[i][j].add(-1);
                }
            }
        }
        // length of k (k = [1 .. s.length()-1])
        for(int k = 1; k < s.length(); k++) {
            for(int i = 0; i < s.length()-k; i++) {
                for(int j = i+k; j < s.length(); j++) {
                    dp[i][j] = dp[i][j] || (dp[i][i+k-1] && dp[i+k][j]);
                    if (connect[i][j] == null) {
                        connect[i][j] = new IntList();
                    }
                    if (dp[i][i+k-1] && dp[i+k][j]) {
                        connect[i][j].add(i+k-1);
                    }
                }
            }
        }
        
        List<String> results = new ArrayList<>();
        if (!dp[0][s.length()-1]) {
            return results;
        }
        List<Integer> points = new ArrayList<>();
        wordBreak(s, connect, 0, s.length()-1, points);
        return results;
    }
    
    private List<String> results = new ArrayList<String>();
    
    public void wordBreak(String s, IntList[][] connect, int start, int end, List<Integer> points) {
        for(Integer k : connect[start][end]) {
		System.out.println(k);
            points.add(k);
            if (k == -1) {
                String result = "";
                for(int i = 0; i < points.size(); i++) {
                    result += points.get(i) + ((i == points.size()-1) ? "" : " ");
                }
                results.add(result);
                return;                
            }
            wordBreak(s, connect, start, k, points);
            wordBreak(s, connect, k+1, end, points);
            points.remove(k);
        }
    }

    public Set<String> insert(String[] s) {
	Set<String> set = new HashSet<String>();
	for(int i = 0; i < s.length; i++) {
		set.add(s[i]);
	}
	return set;
    }

    public static void main(String args[]) {
	WordBreakII w = new WordBreakII();
	Set<String> set = w.insert(new String[]{"o","b","gbdfgiokkfnhl","glibjohcmd","bblcnhelanckn","mflabckflflja","mgda","oheafhajjo","cc","cffalholojikojm","haljiamccabh","gjkdlonmhdacd","ee","bc","mjj","fdlmmbhij","nn","jiaaifedaihn","nhligg","hooaglldlei","hajhebh","ebijeeh","me","eibm","ekkobhajgkem","ohaofonhjakc","n","kjjogm","mhn","odcamjmodie","edmagbkejiocacl","kcbfnjialef","lhifcohoe","akgnn","fbgakjhjb","belggjekmn","oinedhhnolc","ddekcnag","oneoakldakalb","bodnokemafkhkhf","dkefeddjdnab","gflcngff","fgnfmbcogmojgm","ad","jadhganf","lojckbdfj","gadkaoe","jdam","ljjndlnednnombl","aggegbnngohbgga"});
	
	w.wordBreak("aggegbnngohbggalojckbdfjakgnnjadhganfdkefeddjdnabmflabckflfljafdlmmbhijojiaaifedaihnoinedhhnolcjdam", set);

    }
}
