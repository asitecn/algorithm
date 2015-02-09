public class Surround {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] freed = new int[m][n];

        for(int i = 0; i < m; i++) {
            freed[i][0] = (board[i][0] == 'O' ? 1 : 0);
            freed[i][n-1] = (board[i][n-1] == 'O' ? 1 : 0);
        }
        for(int j = 0; j < n; j++) {
            freed[0][j] = (board[0][j] == 'O' ? 1 : 0);
            freed[m-1][j] = (board[m-1][j] == 'O' ? 1 : 0);
        }
       
	//print(freed); 
        int i1 = 1, i2 = m-2, j1 = 1, j2 = n-2;
        for(;i1 <= i2 && j1 <= j2; i1++,i2--,j1++,j2--) {
            
            for(int i = i1; i <= i2; i++) {
                freed[i][j1] |= (board[i][j1] == 'X' ? 0 : freed[i][j1-1] | freed[i-1][j1]);
            }
	    if (i1 == 2) {
		System.out.println("===1===");
//		print(freed);
	    }
            for(int j = j1; j <= j2; j++) {
                freed[i2][j] |= (board[i2][j] == 'X' ? 0 : freed[i2+1][j] | freed[i2][j-1]);
            }
	    if (i1 == 2) {
		System.out.println("===2===");
//		print(freed);
	    }
            for(int i = i2; i >= i1; i--) {
                freed[i][j2] |= (board[i][j2] == 'X' ? 0 : freed[i][j2+1] | freed[i+1][j2]);
            }
	    if (i1 == 2) {
		System.out.println("===3===");
//		print(freed);
	    }
            for(int j = j2; j >= j1; j--) {
                freed[i1][j] |= (board[i1][j] == 'X' ? 0 : freed[i1-1][j] | freed[i1][j+1]);
            }
	    if (i1 == 1) {
		System.out.println("===4===");
		print(freed);
	    }

            for(int j = j1; j <= j2; j++) {
                freed[i1][j] = (board[i1][j] == 'X' ? 0 : freed[i1][j-1]);
            }
            for(int i = i1; i <= i2; i++) {
                freed[i][j2] |= (board[i][j2] == 'X' ? 0 : freed[i-1][j2]);
            }
            for(int j = j2; j >= j1; j--) {
                freed[i2][j] |= (board[i2][j] == 'X' ? 0 : freed[i2][j+1]);
            }
            for(int i = i2; i >= i1; i--) {
                freed[i][j1] |= (board[i][j1] == 'X' ? 0 : freed[i+1][j1]);
            }
		if (i1 == 1) {
	    print(freed);
}
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (freed[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

	public static char[][] convert(String[] str) {
		char[][] board = new char[str.length][str[0].length()];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				board[i][j] = str[i].charAt(j);
			}
		}
		return board;
	}

	public static void print(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void print(int[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String args[]) {
//		char[][] board = Surround.convert(new String[]{"OOOOXX","OOOOOO","OXOXOO","OXOOXO","OXOXOO","OXOOOO"});
		char[][] board = Surround.convert(new String[]{"OXOOOOOOO","OOOXOOOOX","OXOXOOOOX","OOOOXOOOO","XOOOOOOOX","XXOOXOXOX","OOOXOOOOO","OOOXOOOOO","OOOOOXXOO"});
		Surround.solve(board);
		Surround.print(board);		
	}
}
