import java.util.*;
import java.util.concurrent.*;

public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);

    public static void producer() throws Exception {
        Random random = new Random();
        while(true) {
            Thread.sleep(100);
            Integer value = random.nextInt(100);
            queue.put(value);
            System.out.println("Produced value:  " + value + "; Queue size is: " + queue.size());
        }
    }

    public static void consumer() throws Exception {
        Random random = new Random();
        while(true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("Taken value:  " + value + "; Queue size is: " + queue.size());
            }
        }
    }


    public static void main(String args[]) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    producer();
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    consumer();
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
