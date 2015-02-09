import java.util.*;
public class WordLadderII {
    public Set<String> getDict(String[] strs) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < strs.length; i++) {
            set.add(strs[i]);
        }
        return set;
    }

	public static void print(List<List<String>> results) {
        for(List<String> result : results) {
            for(String can : result) {
				System.out.print(can + "\t");
            }
			System.out.println();
		}
		System.out.println();
	}


    private boolean inDistance(String str1, String str2) {
        int dist = 0;
        for(int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dist++;
            }
            if (dist >= 2) {
                return false;
            }
        }
        return (dist == 1);
    }

    List<List<String>> results = new LinkedList<List<String>>();    

    public void findLadders(String start, String end, Set<String> dict, 
                                Map<String, Boolean> visited, LinkedList<String> result) {

        if (inDistance(start, end)) {
            System.out.println("Reaching " + start + "\t" + end);
            LinkedList<String> newResult = new LinkedList<String>(result);
            newResult.add(start);
            newResult.add(end);
            results.add(newResult);
            return;
        }
        
//        for(Map.Entry<String, Integer> me : visited.entrySet()) {
//            String candidate = me.getKey();
//            boolean isVisited = me.getValue();
        for(String candidate : dict) {
            Boolean isVisited = visited.get(candidate);
            System.out.println(candidate + "\t" + isVisited);
            if (inDistance(start, candidate) && (isVisited == null || !isVisited)) {
                System.out.println("adding " + start);
                result.add(start);
                visited.put(candidate, true);
                findLadders(candidate, end, dict, visited, result);
                visited.put(candidate, false);
                result.remove(start);
            }
        }
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        LinkedList<String> result = new LinkedList<String>();
        Map<String, Boolean> visited = new HashMap<>();
        dict.remove(start); dict.remove(end);
        for(String candidate : dict) {
            visited.put(candidate, false);
        }
        findLadders(start, end, dict, visited, result);
        return results;
    }

    public static void main(String args[]) {
        WordLadderII wl = new WordLadderII();
        Set<String> dict = wl.getDict(new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"});
//        Set<String> dict = wl.getDict(new String[]{"qb", "sb"});
        List<List<String>> results = wl.findLadders("qa", "sq", dict);
        wl.print(results);
    }
}
