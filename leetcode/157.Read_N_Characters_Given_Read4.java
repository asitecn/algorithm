/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        
        char[] temp = new char[4];
        List<Character> list = new ArrayList<Character>();
        
        int totalRead = 0;
        while(totalRead < n) {
            int num = read4(temp);
            
            int canRead = (n - totalRead > num ? num : n - totalRead);

            for(int i = 0; i < canRead; i++) {
                list.add(temp[i]);
            }
            totalRead += canRead;
            
            if (num < 4) {
                break;
            }
        }
        
        for(int i = 0; i < list.size(); i++) {
            buf[i] = list.get(i);
        }
        
        return totalRead;
    }
}
