class TrieNode {
    // Initialize your data structure here.
    Character c;
    TrieNode[] children;
    boolean isTerm;

    public TrieNode() {
        children = new TrieNode[26];
    }
    
    public TrieNode(Character c) {
        this.c = c;
        children = new TrieNode[26];
        isTerm = false;
    }
    
    public void setTerm() {
        isTerm = true;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
            if (i == word.length() - 1) {
                node.setTerm();
            }
        }
    }
    
    public TrieNode find(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                return null;
            }
            node = node.children[c - 'a'];
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = find(word);
        return node == null ? false : node.isTerm;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return (find(prefix) != null);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
