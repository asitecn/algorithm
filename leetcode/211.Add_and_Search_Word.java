public class WordDictionary {

    class TrieNode {
        char c;
        TrieNode[] children;
        boolean terminated;
        public TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }
        public boolean contains(char c) {
            return (children[c-'a'] != null);
        }
        public void add(char c) {
            children[c-'a'] = new TrieNode(c);
        }
        public TrieNode get(char c) {
            return children[c-'a'];
        }
        public void setTerminated() {
            this.terminated = true;
        }
    }
    
    TrieNode root = new TrieNode(' ');
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.add(c);
            }
            node = node.get(c);
            if (i == word.length() - 1) {
                node.setTerminated();
            }
        }
    }

    public boolean search(String word, int idx, TrieNode node) {
        char c = word.charAt(idx);
        if (c != '.') {
            TrieNode child = node.get(c);
            if (child == null) {
                return false;
            } else {
                if (idx == word.length() - 1) {
                    return child.terminated;
                } else {
                    return search(word, idx+1, child);
                }
            }
        } else {
            if (idx == word.length() - 1) {
                for(char cc = 'a'; cc <= 'z'; cc++) {
                    TrieNode child = node.get(cc);
                    if (child != null && child.terminated) {
                        return true;
                    }
                }
                return false;
            } else {
                for(char cc = 'a'; cc <= 'z'; cc++) {
                    TrieNode child = node.get(cc);
                    if (child != null && search(word, idx+1, child)) {
                        return true;
                    }
                }
                return false;
            }
        } 
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
