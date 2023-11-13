import java.util.Random;

/**
 * Created by WangSai on 2023/4/18
 */
public class ThreadLocalTest {
    private static final ThreadLocal<String> local = ThreadLocal.withInitial(() -> "six");
    private static final Random rand = new Random(50);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printValue("t" + i);
        }

    }

    private static void printValue(String name) {
        new Thread(() -> {
            Thread t = Thread.currentThread();

            t.setName(name);

            String v = local.get();
            System.out.println(t.getName() + ", before set. v=" + v);
            try {
                Thread.sleep(rand.nextInt(50));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            local.set(name);

            v = local.get();

            System.out.println(t.getName() + ", after set. v=" + v);
        }).start();
    }
}
