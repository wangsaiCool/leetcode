package juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by WangSai on 1/7/21
 */
public class ExecutorInvokeAll {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Long.MAX_VALUE);
        ExecutorInvokeAll test = new ExecutorInvokeAll();
        ExecutorService executor = Executors.newFixedThreadPool(3);
//
//        List<Callable<Boolean>> task = new ArrayList<>();
//        task.add(test.worker);
//        task.add(test.worker);
//        executor.invokeAll(task);

        executor.submit(test.worker);
        executor.submit(test.worker);
        executor.submit(test.worker);

        System.out.println("sleep 5sec");
        Thread.sleep(1000 * 5);
        System.out.println("sleep 5sec done");
        executor.shutdown();
        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdownNow();
        System.out.println("main stop");

    }

    Runnable worker = () -> {
        while (true) {
            try {
                Thread.sleep(921);
                System.out.println(Thread.currentThread().getName() + "_task_test_" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
//                return true;
            }

        }
    };
}
