// Put all together

import java.util.concurrent.*;

class Runner extends Thread {
    public void run() {
        System.out.println("running.");
    }
}

class Runner2 implements Runnable {
    public void run() {
        System.out.println("running.");
    }
}

public class Thread4 {

    public static void main(String[] args) {
        {
            Runner thread1 = new Runner();
            Runner thread2 = new Runner();
            thread1.start();
            thread2.start();
        }
        {
            Thread thread1 = new Thread(new Runner2());
            Thread thread2 = new Thread(new Runner2());
            thread1.start();
            thread2.start();
        }
        {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("running.");
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("running.");
                }
            });
            thread1.start();
            thread2.start();
        }
    }
}
