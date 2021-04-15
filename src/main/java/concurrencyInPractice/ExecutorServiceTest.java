package concurrencyInPractice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by WangSai on 2020/12/30
 */
public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException {
        int num = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        IntStream.range(0, num).forEach(t->
                executorService.submit(() -> {
                    System.out.println(t + "hit call");
                    Thread.sleep(2000L);
                    System.out.println("done");
                    return true;
                })
                );

        System.out.println("submit done, and sleep 20ms then shutdown.");

        Thread.sleep(20L);
        executorService.shutdown();
        while (!executorService.isShutdown()) {
            System.out.println("shut down failed.");
        }
    }
}
