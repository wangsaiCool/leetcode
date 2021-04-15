package concurrencyInPractice;

import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by WangSai on 2020/12/30
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadNum = 3;
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        ExecutorCompletionService<String> ecs = new ExecutorCompletionService<>(executorService);

        IntStream.range(0, threadNum * 8).forEach(
                n -> ecs.submit(() -> {
                    String msg = Thread.currentThread().getName() + "::任务标号: " + n + "::";
                    System.out.println(msg + "start");
                    Thread.sleep(1000L);
                    System.out.println(msg + "done");
                    return String.format("任务标号%d:%d", n, System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(1000));
                })
        );

        for (int i = 0; i < threadNum * 8; i++) {
            Future<String> take = ecs.take();
            String s = take.get();
            System.out.println("获取到的结果:" + s);

        }
        System.out.println("已经获取所有计算结果， 准备shutdown");
        executorService.shutdown();

    }


}
