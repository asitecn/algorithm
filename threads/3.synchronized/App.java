import java.util.concurrent.*;
import java.util.*;

public class App {

    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }

    public static void main(String args[]) {
        App app = new App();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                        increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                        increment();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(Exception e) {
        }
        System.out.println("Count is: " + count);
    }
}

