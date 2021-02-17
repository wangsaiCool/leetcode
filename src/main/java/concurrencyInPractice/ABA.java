package concurrencyInPractice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.IntStream;

/**
 * Created by WangSai on 2021/2/17
 */
public class ABA {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicStampedReference stampedReference = new AtomicStampedReference(0, 0);

    public static void main(String[] args) throws InterruptedException {
        ABA aba = new ABA();
        IntStream.range(0, 10).forEach(
                n -> new Thread(() -> {
                    for (int i = 0; i < 10; i++) {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                        System.out.println("thread no::" + Thread.currentThread().getName());
                        aba.atomicInteger.incrementAndGet();
                    }

                }, n + "").start()
        );

        Thread.sleep(2000L);
        System.out.println(aba.atomicInteger.get());

    }
}
