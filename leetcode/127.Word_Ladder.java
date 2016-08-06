public class Solution {
    
    /* one-way search 
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> next = new LinkedList<>();
        if (expandQueue(beginWord, wordList, queue, endWord)) {
            return 2;
        }
        int depth = 3;
        while(!queue.isEmpty()) {
            String word = queue.poll();
            if (expandQueue(word, wordList, next, endWord)) {
                return depth;
            }
            if (queue.isEmpty()) {
                Queue<String> temp = queue;
                queue = next;
                next = temp;
                depth++;
            }
        }
        return 0;
    }
    
    public void expandQueue(String word, Set<String> wordList, Set<String> set) {
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < 26; j++) {
                char c = (char)('a' + j);
                if (c != word.charAt(i)) {
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if (wordList.contains(newWord)) {
                        set.add(newWord);
                        wordList.remove(newWord);
                    }
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
    }    
    */

    // two way search
    public boolean addNeighbors(Set<String> q, Set<String> big, Set<String> wordList, String word) {
        for(int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder(word);
            for(int j = 0; j < 26; j++) {
                sb.setCharAt(i, (char)('a' + j));
                String w = sb.toString(); 
                if (big.contains(w)) {
                    return true;
                }
                if (wordList.contains(w)) {
                    q.add(w);
                    wordList.remove(w);
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
        return false;
    }
    
    
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        Set<String> small = new HashSet<String>();
        Set<String> big = new HashSet<String>();
        
        small.add(beginWord);
        big.add(endWord);
        
        int dist = 1;
        while(!small.isEmpty() && !big.isEmpty()) {
            if (small.size() > big.size()) {
                Set<String> temp = small;
                small = big;
                big = temp;
            }
            Set<String> next = new HashSet<String>();
            //System.out.println("begin=" + beginSet.toString());
            //System.out.println("end=" + endSet.toString());
            for(String s : small) {
                if (big.contains(s)) {
                    return dist;
                }
                if (addNeighbors(next, big, wordList, s)) {
                    return dist + 1;
                }
            }

            small = next;
            dist++;
        }
        return 0;
    }
}
