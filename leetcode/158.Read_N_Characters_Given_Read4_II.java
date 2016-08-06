/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    LinkedList<Character> remain;

    public Solution() {
        remain = new LinkedList<Character>();
    }
    
    public int read(char[] buf, int n) {
        
        int totalRead = (n < remain.size() ? n : remain.size());
        for(int i = 0; i < totalRead; i++) {
            buf[i] = remain.remove();
        }
        if (totalRead == n) {
            return n;
        }

        while(true) {
            char[] temp = new char[4];
            int m = read4(temp);

            for(int i = 0; i < m; i++) {
                if (totalRead < n) {
                    buf[totalRead++] = temp[i];
                } else {
                    remain.add(temp[i]);
                }
            }            
            
            if (m == 0 || totalRead == n) {
                return totalRead;
            }
        }
    }
}
