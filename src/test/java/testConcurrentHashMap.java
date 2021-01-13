import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.zip.CheckedOutputStream;

/**
 * Created by WangSai on 4/13/21
 */
public class testConcurrentHashMap {

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        map.put("1", "1.1");
        map.put("2", "2.1");
        map.put("3", "3.1");
        monitor();

    }

    private static void monitor() {
        int count = 20;
        System.out.println(map.keySet());
    }
}
