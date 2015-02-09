import java.util.*;
public class PrimeFactors {

    int a = 0;
    int b = 0;
    int c = 0;

    public int prime(int n) {
        int idx = 0;
        int v3 = 1;
        int v5 = 1;
        int v7 = 1;
        int total = v5*v3*v7;
        while(idx < n) {
            int nv3 = v3*3;
            int nv5 = v5*5;
            int nv7 = v7*7;
            if (nv7 >= nv5 && nv7 >= nv3) {
                v7 = nv7;
            } else if (nv5 >= nv7 && nv5 >= nv3) {
                v5 = nv5;
            } else {
                v3 = nv3;
            }
            total = v3*v5*v7;
            idx++;
        }

        return total;
    }



   public static int getKthMagicNumber(int k) {
       if (k <= 0) return 0;
       int val = 1;
       Queue<Integer> Q3 = new LinkedList<Integer>();
       Queue<Integer> Q5 = new LinkedList<Integer>();
       Queue<Integer> Q7 = new LinkedList<Integer>();
       Q3.add(3);
       Q5.add(5);
       Q7.add(7);
       for (--k; k > 0; --k) { // We’ve done one iteration already.
           val = Math.min(Q3.peek().intValue(),
                   Math.min(Q5.peek().intValue(), Q7.peek().intValue()));
           if (val == Q7.peek()) {
               Q7.remove();
           } else {
               if (val == Q5.peek()) {
                   Q5.remove();
               } else { // must be from Q3
                   Q3.remove();
                   Q3.add(val * 3);
               }
               Q5.add(val * 5);
           }
           Q7.add(val * 7);
       }
       return val;
   }

    public static void main(String args[]) {
       PrimeFactors pf = new PrimeFactors();
        System.out.println(pf.getKthMagicNumber(12)); 
//        System.out.println(pf.prime(12)); 
    }

}
