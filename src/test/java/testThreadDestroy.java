import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by WangSai on 3/16/21
 */
public class testThreadDestroy {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        System.out.println("start main");
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "wake up");
                    return;
                }
            });
        }

        System.out.println("finished main");

    }
}
