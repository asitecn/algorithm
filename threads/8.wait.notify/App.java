import java.util.*;
import java.util.concurrent.*;

class Processor {

    LinkedList<Integer> list = new LinkedList<>();

    public void produce() throws Exception {
        synchronized(list) {
            
            System.out.println("Producer thread running ....");
            wait();
            System.out.println("Producer thread Resumed ....");
        }
    }

    public void consume() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized(list) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }
}

public class App {

    public static void main(String args[]) throws Exception {
        Processor processor = new Processor();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.produce();
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    processor.consume();
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
