public class Solution {
    class Node {
        String word;
        Node parent;
        public Node(String word, Node parent) {
            this.word = word;
            this.parent = parent;
        }
    }
    
    public void addNeighbors(Node parent, Set<String> wordList, Queue<Node> queue, Set<String> removeSet) {
        String word = parent.word;
        StringBuilder sb = new StringBuilder(word);
        for(int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if (c != word.charAt(i)) {
                    sb.setCharAt(i, c);
                    String w = sb.toString();
                    if (wordList.contains(w)) {
                        queue.offer(new Node(w, parent));
                        // should not remove now, should remove in the end.
                        removeSet.add(w);
                    }
                }
            }
            sb.setCharAt(i, word.charAt(i));
        }
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Node root = new Node(beginWord, null);
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        Set<String> removeSet = new HashSet<>();
        addNeighbors(root, wordList, q1, removeSet);
                for(String w : removeSet) {
                    wordList.remove(w);
                }        
        
        List<List<String>> res = new ArrayList<>();
        
        boolean found = false;
        while(!q1.isEmpty()) {
            Node node = q1.remove();
            String word = node.word;
            if (endWord.equals(word)) {
                addResult(res, node);
                found = true;
            }
            addNeighbors(node, wordList, q2, removeSet);
            if (q1.isEmpty()) {
                if (!found) {
                    Queue<Node> temp = q1;
                    q1 = q2;
                    q2 = temp;
                }
                for(String w : removeSet) {
                    wordList.remove(w);
                }
            }
        }
        
        return res;
    }
    
    public void addResult(List<List<String>> res, Node node) {
        List<String> list = new ArrayList<>();
        while(node != null) {
            list.add(0, node.word);
            node = node.parent;
        }
        res.add(list);
    }
}
