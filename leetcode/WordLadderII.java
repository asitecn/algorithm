import java.util.*;
public class WordLadderII {

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

    public Set<String> toSet(String[] s) {
        Set<String> set = new HashSet<String>();
        for(int i = 0; i < s.length; i++) {
            set.add(s[i]);
        }
        return set;
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<List<String>>();
        List<String> result = new ArrayList<>();
        dict.remove(start);
        dict.remove(end);
        findLadders(start, end, dict, result, results);
        return results;
    }

    int min = Integer.MAX_VALUE;
    
    public void findLadders(String start, String end, Set<String> dict, List<String> result, List<List<String>> results) {
        if (inDistance(start, end)) {
            if (min > results.size()) {
                min = result.size();
//                results.clear();
            }
            List<String> new_result = new ArrayList<String>(result);
            new_result.add(end);
            results.add(new_result);
            return;
        }
        if (result.size() >= min) {
            return;
        }

        List<String> list = new ArrayList<>();
        for (Iterator<String> iterator = dict.iterator(); iterator.hasNext();) {
            String candidate = iterator.next();
            if (inDistance(start, candidate)) {
                list.add(candidate);
                iterator.remove();
            }
        }
        for (String str : list) {
            result.add(str);
            findLadders(str, end, dict, result, results);
            result.remove(str);
        }
        /*
        for (String str : list) {
            dict.add(str);
        }*/
    }

    public void print(List<List<String>> list) {
        for(List<String> l : list) {
            for(String s : l) {
                System.out.print(s+",");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        WordLadderII w = new WordLadderII();
        List<List<String>> list = w.findLadders("nape", "mild", w.toSet(new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"}));

        System.out.println("nape");
        System.out.println("mild");
        w.print(list);
    }
}
