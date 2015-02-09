import java.util.*;
import java.util.concurrent.*;

class Worker {
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private Random random = new Random();

//    public Object lock1 = new Object();
//    public Object lock2 = new Object();

    public void stageOne() {
        synchronized(list1) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            list1.add(random.nextInt(100));
        }
    }

    public void stageTwo() {
        synchronized(list2) {
            try {
                Thread.sleep(1);
            } catch (Exception e) {
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process() {
        for(int i = 0; i < 1000; i++) {
                stageOne();
                stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (Exception e) {}

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }
}

public class App {

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}
