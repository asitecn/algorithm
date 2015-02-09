import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Processor {

    private volatile int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for(int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws Exception {
        lock.lock();
        System.out.println("Waiting");
        cond.await();
        System.out.println("Woken up");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws Exception {
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press return key");
        new Scanner(System.in).nextLine();
        System.out.println("Got Press return key");
        cond.signal();

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished() throws Exception {
        System.out.println("Count is: " + count);
    }
}

public class App {

    public static void main(String args[]) throws Exception {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.firstThread();
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.secondThread();
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        processor.finished();
    }
}
