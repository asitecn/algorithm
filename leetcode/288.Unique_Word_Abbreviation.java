public class ValidWordAbbr {
    Map<String, Set<String>> abbr = new HashMap<String, Set<String>>();
    
    public String toAbbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    public ValidWordAbbr(String[] dictionary) {
        for(int i = 0; i < dictionary.length; i++) {
            String signature = toAbbr(dictionary[i]);
            if (!abbr.containsKey(signature)) {
                abbr.put(signature, new HashSet<String>());
            }
            abbr.get(signature).add(dictionary[i]);
        }
    }

    public boolean isUnique(String word) {
        String signature = toAbbr(word);
        if (!abbr.containsKey(signature)) {
            return true;
        }
        Set set = abbr.get(signature);
        return (set.size() == 1 && set.contains(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
