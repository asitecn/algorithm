import java.util.*;
import java.util.concurrent.*;

class Processor {

    LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();
    private Random random = new Random();

    public void produce() throws Exception {

        int value = 0;
        while(true) {
            synchronized(lock) {
                while(list.size() == LIMIT) {
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
            Thread.sleep(random.nextInt(500));
        }
    }

    public void consume() throws Exception {
        while(true) {
            synchronized(lock) {
                while(list.size() == 0) {
                    lock.wait();
                }
                System.out.print("List size is: " + list.size());
                int value = list.remove();
                System.out.println("; value is " + value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}

public class App {

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
