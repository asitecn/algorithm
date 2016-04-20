import java.util.*;
import java.util.concurrent.*;

public class ProducerConsumer {

    public static void main(String[] args) {

        ProducerConsumer pc = new ProducerConsumer();
        pc.test();
    }

    public void test() {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(producer);
        es.submit(consumer);
        try {
            es.shutdown();
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (Exception e) {

        }
    }
}


class Producer implements Runnable {

    Queue<Integer> queue;    
    volatile int count = 0;

    public Producer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            if (queue.size() >= 10) {
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}
            } else {
                synchronized(queue) {
                    queue.offer(count++);
                }
            }
        }
    }
    
}


class Consumer implements Runnable {

    Queue<Integer> queue;    

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while(true) {
            if (queue.size() > 0) {
                synchronized(queue) {
                    System.out.println(queue.remove());
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch(Exception e) {}
            }
        }
    }
    
}
