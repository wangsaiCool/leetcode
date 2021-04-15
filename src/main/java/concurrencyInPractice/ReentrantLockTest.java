package concurrencyInPractice;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by WangSai on 2021/2/24
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLockTest lockTest = new ReentrantLockTest();
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();
    }
}
