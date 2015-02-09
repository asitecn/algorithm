import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Account {
    private int balance = 10000;
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }
    public int getBalance() {
        return balance;
    }
    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}

class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();
    private Random rand = new Random();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock firstLock, Lock secondLock) throws Exception {
        while(true) {
            // acquire locks
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;
            try {
                gotFirstLock = firstLock.tryLock();
                gotSecondLock = secondLock.tryLock();
            } finally {
                if (gotFirstLock && gotSecondLock) {
                    return;
                }
                if (gotFirstLock) {
                    firstLock.unlock();
                }
                if (gotSecondLock) {
                    secondLock.unlock();
                }
            }

            // locks not acquired
            Thread.sleep(1);
        }
    }

    public void firstThread() throws Exception {
        for(int i = 0; i < 10000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, rand.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() throws Exception {
        for(int i = 0; i < 10000; i++) {
            acquireLocks(lock2, lock1);
            try {
                Account.transfer(acc2, acc1, rand.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() throws Exception {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}

public class App {

    public static void main(String args[]) throws Exception {
        Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.firstThread();
                } catch (Exception e) {}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    runner.secondThread();
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        runner.finished();
    }
}
