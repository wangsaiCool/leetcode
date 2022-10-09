package filesHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2022/8/18
 */
public class TestMapStream {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }
        map.entrySet().stream()
                .filter(kv -> kv.getKey() > 5)
                .forEach(kv -> System.out.println(kv.getKey()));
    }
}
