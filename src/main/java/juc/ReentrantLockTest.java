package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WangSai on 1/5/21
 */
public class ReentrantLockTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("run t1");
                reentrantLock.lockInterruptibly();
                System.out.println("t1 get lock");
                while (true) {
                    //
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("t1 unlock");
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                reentrantLock.lock();
                Thread.sleep( 60 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();

            }

        });

        t2.start();
        t1.start();
        Thread.sleep(2 * 1000);
        t1.interrupt();
        System.out.println("t interrupt");
    }

}
