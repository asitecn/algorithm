import java.util.*;
import java.util.concurrent.*;

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override    
    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(5000);
        } catch(Exception e) {}
        System.out.println("Completed: " + id);
    }
}

public class App {
    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }
        System.out.println("All tasks submitted.");

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch(Exception e) {}
        System.out.println("All tasks completed.");
    }
}
