import java.util.*;
import java.util.concurrent.*;
public class App1 {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Starting...");

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                Random rand = new Random();
                for(int i = 0; i < 1E8; i++) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("I am interrupted");
                        break;
                    }
                    System.out.println(i + "\t" +Math.sin(rand.nextDouble()));
                }
                return null;
            }

        });


        exec.shutdown();
        Thread.sleep(500);
        exec.shutdownNow();
//        future.cancel(true);
        exec.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Finished.");
        
    }
}
