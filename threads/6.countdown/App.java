import java.util.*;
import java.util.concurrent.*;

class Processor implements Runnable {

    private CountDownLatch latch;
    public Processor(CountDownLatch latch) {
        this.latch = latch;
    } 

    @Override 
    public void run() {
        System.out.println("Started.");
        try {
            Thread.sleep(3000);
        } catch(Exception e) {}
  
        latch.countDown();
    }
}

public class App {
    public static void main(String args[]) {
        CountDownLatch latch = new CountDownLatch(3);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 3; i++) {
            executor.submit(new Processor(latch));
        }
        try {
            latch.await();
            executor.shutdown();
        } catch(Exception e) {}
        System.out.println("Completed.");
    }
}
