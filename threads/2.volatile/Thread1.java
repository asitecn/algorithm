import java.util.concurrent.*;
import java.util.*;

class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while(running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (Exception e) { }
        }
    }

    //@Override
    public void shutdown() {
        running = false;
    }
}


public class Thread1 {
    public static void main(String args[]) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Press return to stop ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        proc1.shutdown();
    }
}

