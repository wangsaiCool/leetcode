package juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by WangSai on 1/6/21
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock r = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock w = readWriteLock.writeLock();

        r.lock();

    }
}
