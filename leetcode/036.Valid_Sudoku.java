public class Solution {
    public boolean isValidSudoku(char[][] board) {
        {
            for(int i = 0; i < 9; i++) {
               Set<Character> set = new HashSet<Character>();
                for(int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c == '.') {
                        continue;
                    }
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        {
            for(int j = 0; j < 9; j++) {
               Set<Character> set = new HashSet<Character>();
                for(int i = 0; i < 9; i++) {
                    char c = board[i][j];
                    if (c == '.') {
                        continue;
                    }
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        
        {

            for(int k1 = 0; k1 < 3; k1++) {
                for(int k2 = 0; k2 < 3; k2++) {
                    Set<Character> set = new HashSet<Character>();
                    for(int i = 0; i < 3; i++) {
                        for(int j = 0; j < 3; j++) {
                            char c = board[3 * k1 + i][3 * k2 + j];
                            if (c == '.') {
                                continue;
                            }
                            if (set.contains(c)) {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }
}
