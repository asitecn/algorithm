import java.util.*;
public class App {

    public static void main(String[] args) throws Exception {
        
        System.out.println("Starting...");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Random rand = new Random();
                for(int i = 0; i < 1E8; i++) {
/*
                    try {
                            Thread.sleep(1);
                    } catch (Exception e) {
*/
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("I am interrupted");
                        break;
                    }
/*
                        break;
                    }
*/
                    System.out.println(i + "\t" +Math.sin(rand.nextDouble()));
                }
            }
        });

        t.start();
        Thread.sleep(100);
        t.interrupt();

        t.join();

        System.out.println("Finished.");
        
    }
}
