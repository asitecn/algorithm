import java.util.*;
import java.util.concurrent.*;

class Processor {

    private static final int capacity = 5;
//    private final Semaphore sema = new Semaphore(5, true); 
    LinkedList<Integer> list = new LinkedList<>();

    public void produce() throws Exception {
        while(true) {
            synchronized(list) {
                while (list.size() == capacity) {
                    list.wait();
                } 
                Random rand = new Random();
                Integer value = rand.nextInt(100);
                list.add(value);
                System.out.println("Produced " + value);
                list.notify();
            }
        }
    }

    public void consume() throws Exception {
       while(true) {
                synchronized(list) {
                while (list.size() == 0) {
                    list.wait();
                } 
                Integer value = list.remove();
                System.out.println("Removed " + value);
                list.notify();
            }
        }
    }
}

public class App1 {

    public static void main(String args[]) throws Exception {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
