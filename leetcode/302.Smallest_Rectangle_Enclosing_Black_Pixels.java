// Solution 1
public class Solution {
    
    public int searchX(char[][] image, int x, int direction) {
        int count = 0;
        while(x >= 0 && x < image.length) {
            boolean found = false;
            for(int j = 0; j < image[0].length; j++) {
                if (image[x][j] == '1') {
                    found = true;
                    count++;
                    break;
                }
            }
            if (!found) {
                break;
            }
            x += direction;
        }
        return count;
    }

    public int searchY(char[][] image, int y, int direction) {
        int count = 0;
        while(y >= 0 && y < image[0].length) {
            boolean found = false;
            for(int i = 0; i < image.length; i++) {
                if (image[i][y] == '1') {
                    found = true;
                    count++;
                    break;
                }
            }
            if (!found) {
                break;
            }
            y += direction;
        }
        return count;
    }
    
    public int minArea(char[][] image, int x, int y) {
        int left = searchY(image, y-1, -1);
        int right = searchY(image, y+1, 1);
        int up = searchX(image, x-1, -1);
        int down = searchX(image, x+1, 1);
        //System.out.println(left + "\t" + right + "\t" + up + "\t" + down);
        return (left + right + 1) * (up + down + 1);
    }
}

// Solution 2, same thought, re-implemented 1 month later
public class Solution {
    public int countCol(char[][] image, int m, int n, int j, int dir) {    
        int count = 0;
        while(j >= 0 && j < n) {
            boolean found = false;
            for(int i = 0; i < m; i++) {
                if (image[i][j] == '1') {
                    count++;
                    j += dir;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return count;
    }


    public int countRow(char[][] image, int m, int n, int i, int dir) {    
        int count = 0;
        while(i >= 0 && i < m) {
            boolean found = false;
            for(int j = 0; j < n; j++) {
                if (image[i][j] == '1') {
                    count++;
                    i += dir;
                    found = true;
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return count;
    }
    
    public int minArea(char[][] image, int x, int y) {
        /*
            [
              "0010",
              "0110",
              "0100"
            ]        
        */
        int m = image.length;
        int n = image[0].length;

        int cx = countRow(image, m, n, x + 1, 1) + countRow(image, m, n, x - 1, -1) + 1;
        int cy = countCol(image, m, n, y + 1, 1) + countCol(image, m, n, y - 1, -1) + 1;
        return cx*cy;
        
    }
}
