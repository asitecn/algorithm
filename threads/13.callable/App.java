import java.util.*;
import java.util.concurrent.*;
public class App {

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override 
            public Integer call() {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if (duration > 2000) {
                    throw new RuntimeException("Sleeping for too long");
                }

                System.out.println("Starting...");
                try {
                    Thread.sleep(duration);
                } catch(Exception e) {}
                System.out.println("Finished.");
                return duration;
            }
        });
        executor.shutdown();
        try {
            System.out.println(future.get());
        } catch (Exception e) {
//            e.printStackTrace();
            RuntimeException ex = (RuntimeException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}
