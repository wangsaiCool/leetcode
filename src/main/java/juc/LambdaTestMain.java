package juc;

/**
 * Created by WangSai on 1/11/21
 */
public class LambdaTestMain {

    public static void main(String[] args) {
        LambdaTestMain lambdaTest = new LambdaTestMain();
        LambdaTest4 t4 = new LambdaTest4() {
            @Override
            protected String getName() {
                String msg = "INIT_GET_NAME_METHOD_" + Thread.currentThread().getName();
                System.out.println(msg);
                return msg;
            }
        };
        new Thread(()->t4.getName()).start();
        new Thread(()->t4.call()).start();
        new Thread(()->t4.test()).start();
        new Thread(() -> System.out.println("SOUT_METHOD")).start();
        new Thread(() -> {

                System.out.println("From new Runnable.");
        }).start();

        new Thread(() -> new LambdaTest4() {
            @Override
            protected String getName() {
                String msg = "HA_HA";
                System.out.println(msg);
                return msg;
            }

        }).start();

        new Thread(lambdaTest.new LambdaTest5()).start();
    }

    class LambdaTest5 extends LambdaTest4{

        @Override
        protected String getName() {
            String msg = "LambdaTest5_getName";
            System.out.println(msg);
            return msg;
        }
    }

}
