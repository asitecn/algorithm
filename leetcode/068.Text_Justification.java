public class Solution {
    
    /*    
    words: ["This", "is", "an", "example", "of", "text", "justification."]
    L: 16. 
    */
    
    public String materialize(List<String> list, int maxWidth, int charCount, boolean isLeftJustify) {
        int spaces = maxWidth - charCount;
        // w1, w2, w3 => 5 spaces
        StringBuilder sb = new StringBuilder();
        if (isLeftJustify) {
            for(int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(" ");
                    spaces--;
                }
                sb.append(list.get(i));
            }
            for(int i = 0; i < spaces; i++) {
                sb.append(" ");
            }
        } else {
            int avgSpaces = list.size() == 1 ? spaces : spaces / (list.size() - 1);
            int extraSpaces = spaces - avgSpaces*(list.size() - 1);
            for(int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    for(int j = 0; j < avgSpaces; j++) {
                        sb.append(" ");
                    }
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                }
                sb.append(list.get(i));
            }
        }
        return sb.toString();
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        
        List<String> list = new ArrayList<>();
        int charCount = 0;
        for(int i = 0; i <= words.length; i++) {
            String word = (i == words.length ? "" : words[i]);
            if (i == words.length || charCount + word.length() + list.size() > maxWidth) {
                boolean isLeftJustify = (i == words.length || list.size() == 1);
                res.add(materialize(list, maxWidth, charCount, isLeftJustify));
                charCount = 0;
                list = new ArrayList<>();
            }
            list.add(word);
            charCount += word.length();
        }
        return res;
    }
}
