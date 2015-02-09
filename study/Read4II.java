/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

import java.util.*;
public class Read4II {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    public int read4(char[] buf) {
        buf[0] = 'a'; buf[1] = 'b';
        return 2;
    }

    boolean eof = false;
    int offset = 0;
    char[] result;
    
    public int read(char[] buf, int n) {
        if (n == 0) {
            return 0;
        }
        char[] newResult = new char[n];
        int cumBytesRead = 0;
        int bytesRead = 0;
        while(bytesRead < n) {
            char[] buffer = new char[4];
            int temp = read4(buffer);
            cumBytesRead += temp;
            if (!(cumBytesRead < offset+1 || (cumBytesRead == offset+1 && offset % 4 == 3))) {
                System.out.println("temp=" + temp + ",offset=" + offset);
                for(int i = 0; i < cumBytesRead-offset && i < n && i < temp; i++) {
                        System.out.println("i=" + i + ",i-offset=" + (i-offset));
                        newResult[bytesRead++] = buffer[offset+i];
                        System.out.println("bytesRead=" + bytesRead);
                }
            }
            if (temp <= 3) {
                break;
            }
        }
        
        if (result != null) {
            buf = Arrays.copyOf(result, offset+bytesRead);
        }
        for(int i = 0; i < bytesRead; i++) {
            buf[offset + i] = newResult[i];
        }
        offset += bytesRead;
        System.out.println(bytesRead + "\t" + offset);
        return bytesRead;
    }

    public static void main(String args[]) {
        Read4II read4 = new Read4II();
        char buf[] = new char[4];
        read4.read(buf, 1);
//        buf = new char[4];
        read4.read(buf, 2);
        System.out.println(buf);
    }
}
