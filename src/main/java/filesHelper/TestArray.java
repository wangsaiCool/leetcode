package filesHelper;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by WangSai on 2022/7/18
 */
public class TestArray {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        Future<Long> f1 = pool.submit(() -> {
            Thread.sleep(TimeUnit.SECONDS.toMillis(6));

            System.out.println("f1 done");
            return System.currentTimeMillis();
        });

        Future<Long> f2 = pool.submit(() -> {
            Thread.sleep(TimeUnit.SECONDS.toMillis(4));

            System.out.println("f2 done");
            return System.currentTimeMillis();
        });

        Future<Long> f3 = pool.submit(() -> {
            Thread.sleep(TimeUnit.SECONDS.toMillis(3));

            System.out.println("f3 done");
            return System.currentTimeMillis();
        });

        System.out.println("diff1:" + (System.currentTimeMillis() - start));
        System.out.printf("r1:{%s}, r2:{%s}, r3:{%s}\n", f1.get(), f2.get(), f3.get());
        System.out.println("diff2:" + (System.currentTimeMillis() - start));
        pool.shutdownNow();
    }

}
