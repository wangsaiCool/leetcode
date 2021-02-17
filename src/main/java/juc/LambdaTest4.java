package juc;

import java.util.concurrent.Callable;

/**
 * Created by WangSai on 1/11/21
 */
public abstract class LambdaTest4 implements Callable<String>, Runnable {

    protected abstract String getName();

    public String test() {
        String msg = "TEST_METHOD_" + Thread.currentThread().getName();
        System.out.println(msg);
        return msg;
    }

    @Override
    public String call() {
        String msg = "CALL_METHOD_" + Thread.currentThread().getName();
        System.out.println(msg);
        return msg;
    }

    public void run() {
        System.out.println("run once.");
    }
}
