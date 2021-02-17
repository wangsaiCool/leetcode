package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by WangSai on 1/6/21
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger ati = new AtomicInteger();

        ati.incrementAndGet();
    }
}
