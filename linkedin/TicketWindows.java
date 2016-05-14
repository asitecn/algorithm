import java.util.*;

public class TicketWindows {
/*
 2. There are "n" ticket windows in the railway station. ith window has ai tickets available. 
    Price of a ticket is equal to the number of tickets remaining in that window at that time. 
    When "m" tickets have been sold, what's the maximum amount of money the railway station can earn? 
    exa. n=2, m=4 in 2 window available tickets are : 2 , 5 2nd window sold 4 tickets so 5+4+3+2=14.
*/

    
    public static int maxSale(int[] arr, int m) {
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        // (a,b) -> (b,a));
        for(int ticket : arr) {
            queue.offer(ticket);
        }
        int sum = 0;
        while (m > 0) {
            if (queue.isEmpty()) {
                break;
            }
            int max = queue.poll();
            int top = (queue.isEmpty() ? 0 : queue.peek());
            for(; m > 0 && max >= top; m--, max--) {
                sum += max;
            }
            if (max > 0) {
                queue.offer(max);
            }
        }
        return sum;
    }


    public static void main(String args[]) {
        int[] arr = new int[]{3,5};
        int m = 4;
        System.out.println(Arrays.toString(arr) + "\t" + m + "\t" + TicketWindows.maxSale(arr, m));
    }
} 
