package juc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by WangSai on 1/6/21
 */
public class ExecutorsTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println(Thread.currentThread().getName() + "_scheduleAtFixedRate"), 2, 2, TimeUnit.SECONDS);
        System.out.println("main stop");
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + ":start");
//                        Thread.sleep(new Random().nextInt(10) * 1000);
//                        System.out.println(Thread.currentThread().getName() + ":wake up");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    throw new IllegalArgumentException();
//                }
//            });
//        }
//
//        for (int i = 0; i < 100; i++) {
//            int threadCount = threadMXBean.getThreadCount();
//            System.out.println(threadCount);
//            Thread.sleep(1000);
//            System.out.println(i);
//        }
    }
}
