import java.util.*;
public class PalindromePartition {
    
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int start = 0, end = s.length()-1;
        while(start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    List<List<String>> results = new LinkedList<List<String>>();
    public void partition(String s, int start, LinkedList<String> result) {
        if (start >= s.length()) {
            results.add(new LinkedList<String>(result));
            return;
        }
        for(int i = start+1; i <= s.length(); i++) {
            System.out.println(start + "\t" + i + "\t" + s);
            String prefix = s.substring(start, i);
            System.out.println(start + "\t" + i + "\t" + prefix);
            if (!isPalindrome(prefix)) {
                continue;
            }
            result.add(prefix);
            partition(s, i, result);
            result.removeLast();
//            print2(result);
        }
    }
    
    public List<List<String>> partition(String s) {
        LinkedList<String> result = new LinkedList<String>();
        partition(s, 0, result);
        return results;
    }

    public void print2(List<String> result) {
            System.out.println("==in print2==");
            for(String str : result) {
                System.out.print(str + "\t");
            }
            System.out.println();
    }

    public void print(List<List<String>> results) {
        for(List<String> result : results) {
            for(String str : result) {
                System.out.print(str + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        PalindromePartition pp = new PalindromePartition();
        List<List<String>> results = pp.partition("efe");
        System.out.println("--final--");
        pp.print(results);
    }
}
