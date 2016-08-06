public class Solution {
    
    class TrieNode {
        Character c;
        Map<Character, TrieNode> children;
        boolean isTerm;
        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<Character, TrieNode>();
            isTerm = false;
        }
        public void setTerm() {
            isTerm = true;
        }
        public boolean contains(char c) {
            return children.containsKey(c);
        }
        public TrieNode get(char c) {
            return children.get(c);
        }
    }

    public void add(TrieNode root, String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.contains(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
            if (i == word.length() - 1) {
                node.setTerm();
            }
        }
    }
    
    public void dfs(Set<String> result, char[][] board, boolean[][] visited, String path, int i, int j, TrieNode root) {
        visited[i][j] = true;

        path += board[i][j];
        if (root.isTerm) {
            result.add(path);
        }
        if (i > 0 && !visited[i-1][j] && root.contains(board[i-1][j])) {
            dfs(result, board, visited, path, i - 1, j, root.get(board[i-1][j]));
        }
        if (i < board.length - 1 && !visited[i+1][j] && root.contains(board[i+1][j])) {
            dfs(result, board, visited, path, i + 1, j, root.get(board[i+1][j]));
        }
        if (j > 0 && !visited[i][j-1] && root.contains(board[i][j-1])) {
            dfs(result, board, visited, path, i, j - 1, root.get(board[i][j - 1]));
        }
        if (j < board[0].length - 1 && !visited[i][j+1] && root.contains(board[i][j + 1])) {
            dfs(result, board, visited, path, i, j + 1, root.get(board[i][j + 1]));
        }
        visited[i][j] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<String>();
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new LinkedList<String>(result);
        }
        int m = board.length; 
        int n = board[0].length;
        int maxLen = m*n;
        
        TrieNode root = new TrieNode(' ');
        for(int i = 0; i < words.length; i++) {
            if (words[i].length() <= maxLen) {
                add(root, words[i]);
            }
        }

        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char c = board[i][j];
                if (root.contains(board[i][j])) {
                    dfs(result, board, visited, "", i, j, root.get(c));
                }
            }
        }
        return new LinkedList<String>(result);
    }
}
