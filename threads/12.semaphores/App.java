import java.util.*;
import java.util.concurrent.*;

class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;
    private Semaphore sem = new Semaphore(10);

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
        sem.acquire();
        synchronized(this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }

        Thread.sleep(2000);
        synchronized(this) {
            connections--;
        }
        } catch (Exception e) {
        } finally {
            sem.release();
        }
    }
}

public class App {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 200; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    Connection.getInstance().connect();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

/*
        Semaphore sem = new Semaphore(1);

        sem.acquire();
//        sem.release();

        System.out.println("Available permits: " + sem.availablePermits());
*/
    }

}
