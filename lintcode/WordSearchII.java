import java.util.*;

class TrieNode {
    public boolean isEnd = false;
    public TrieNode[] children = new TrieNode[26];
    
    public void add(String s, int index) {
//        System.out.println(s + "\t" + index);
        if (index == s.length()) {
            isEnd = true;
            return;
        } 
        
        if (children[s.charAt(index) - 'a'] == null) {
            children[s.charAt(index) - 'a'] = new TrieNode();
        }
        children[s.charAt(index)-'a'].add(s, index+1); 
    }

    public char parent = '#';
    public char c = '#';
    public void print() {
        List<TrieNode> thisLevel = new ArrayList<TrieNode>();
        List<TrieNode> nextLevel = new ArrayList<TrieNode>();
        thisLevel.add(this);
        while(thisLevel.size() > 0) {
            for(int i = 0; i < thisLevel.size(); i++) {
                TrieNode node = thisLevel.get(i);
                System.out.print(node.c + "(" + node.parent + ")\t");
                for(int j = 0; j < node.children.length; j++) {
                    if (node.children[j] != null) {
                        node.children[j].c = (char)(j + 'a');
                        node.children[j].parent = node.c;
                        nextLevel.add(node.children[j]);
                    }
                }
            }
            thisLevel = nextLevel;
            nextLevel = new ArrayList<TrieNode>();
            System.out.println();
        }
    }
};


public class WordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of String
     * @return: A list of String
     */
    public List<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Set<String> set = new HashSet<>();
        TrieNode trie = new TrieNode(); 
        for(int i = 0; i < words.size(); i++) { 
            trie.add(words.get(i),0);
        }

//        trie.print();
//        System.exit(1);

        boolean[][] visited = new boolean[board.length][board[0].length];
        
        String temp = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                search(board, visited, trie, i, j, temp, set); 
            }
        }
        
        return new ArrayList<String>(set);
    }
    
    private void search(char[][] board, boolean[][] visited, TrieNode trie, int i, int j, String tmp, Set<String> set) {
        if (trie == null || i < 0 || i >= board.length || j < 0 || j >=board[0].length) {
             return; 
        }
        if (trie.children[board[i][j]-'a'] == null || visited[i][j]) {
            return;
        }

        //1   0
        //1   3
        //2   3        
        //se
//        System.out.println(i + "\t" + j);
        //1   0
        //1   3
        //0   3
        //se
        //2   3
        //se
        //2   2
        //see


        TrieNode nextNode = trie.children[board[i][j]-'a'];
        tmp += board[i][j];
        if (nextNode.isEnd) {
            System.out.println(tmp);
            set.add(tmp); 
        }
        
        visited[i][j] = true;
        int x[] ={0, 0, -1, 1};
        int y[] ={-1,1, 0, 0};
        //int x[] ={0, 1};
        //int y[] ={1, 0};
        for(int k = 0; k < x.length; k++) {
            search(board, visited, nextNode, i+x[k], j+y[k], tmp, set);
        }
        visited[i][j] = false; 
    } 

    public static void main(String args[]) {
        WordSearchII ws = new WordSearchII();

        char[][] board = {
//            {'d', 'o', 'a', 'f'},
//            {'a', 'g', 'a', 'i'},
//            {'d', 'c', 'a', 'n'},
            {'a','b','c','e'},
            {'s','f','c','s'},
            {'a','d','e','e'}
        };

        //1   0
        //1   3
        //2   3        
        //se
        //1   0
        //1   3
        //0   3
        //se
        //2   3
        //se
        //2   2
        //see


        ArrayList<String> words = new ArrayList<String>();
/*
        words.add("dog");
        words.add("dad");
        words.add("dgdg");
        words.add("can");
        words.add("again");
*/
        words.add("see");
        words.add("se");
        List<String> results = ws.wordSearchII(board, words);
        for(String result : results) {
            System.out.println(result);
        }
    }
            //      ROOT
            //      d                                       c                   a
            //      o       a       g                       a                   g
            //      g       d       d                       n                   a
            //                      g                                           i
            //                                                                  n

};
