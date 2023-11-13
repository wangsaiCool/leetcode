
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * Created by WangSai on 2023/5/16
 */
public class GuavaTest {

    public static void main(String[] args) {

//        Optional<Integer> op1 = Optional.of(5);
//        System.out.println(op1.get());
//        System.out.println(op1.isPresent());
//        System.out.println(op1.or(4));
//
//        Ordering.natural();
//        ImmutableSet<Integer> set = ImmutableSet.of(1, 2,3);
//        Spliterator<Integer> spliterator = set.spliterator();
//        spliterator.trySplit();
//        System.out.printf("RateLimiter[stableRate=%3.4fqps]", 0.0001);
//        System.out.printf("RateLimiter[stableRate=%3.1fqps]", 0.001);
//        System.out.printf("RateLimiter[stableRate=%3.1fqps]", 0.01);
//        System.out.printf("RateLimiter[stableRate=%3.1fqps]", 0.1);
//        System.out.printf("RateLimiter[stableRate=%3.1fqps]", 1.0);
//        System.out.printf("RateLimiter[stableRate=%3.1fqps]", 10.0);
        Map<Integer, String> sceneConfig = null;
        test(sceneConfig);

        sceneConfig = new HashMap<>();
        test(sceneConfig);

        sceneConfig.put(1, "2");
        test(sceneConfig);

    }

    private static void test(Map<Integer, String> sceneConfig) {
        System.out.println("===");
        Optional.ofNullable(sceneConfig)
                .ifPresent(map -> map.forEach((k, v) -> {
                    System.out.println(k + ":" + v);
                }));
    }
}
