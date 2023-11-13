package filesHelper;

//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
//import com.google.common.cache.RemovalListener;
//
//import java.util.Iterator;
//import java.util.Map;
//import java.util.concurrent.ConcurrentMap;
//import java.util.concurrent.TimeUnit;

/**
 * Created by WangSai on 2022/8/18
 */
public class GuavaLruCache {
//
//    Cache<String, String> cache;
//
//    public GuavaLruCache() {
//        cache = CacheBuilder.newBuilder()
//                .maximumSize(20)
//                .expireAfterWrite(5, TimeUnit.SECONDS)
//                .removalListener(
//                        (RemovalListener<String, String>) notification -> handleRemove(notification.getKey(), notification.getValue())
//                ).build();
//    }
//
//    private void handleRemove(String key, String value) {
//        System.out.printf("handleRemove. key:%s, value:%s\n", key, value);
//    }
//
//    public static void main(String[] args) {
//
//        GuavaLruCache lruCache = new GuavaLruCache();
////        lruCache.startClean();
//        lruCache.startRandomInvalid();
//        lruCache.startPutCache();
//
//    }
//
//    private void startRandomInvalid() {
//        new Thread(() -> {
//            while (true) {
//                try {
//                    Thread.sleep(10_000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                ConcurrentMap<String, String> cached = cache.asMap();
//                Iterator<Map.Entry<String, String>> iterator = cached.entrySet().stream().iterator();
//                Map.Entry<String, String> entry = iterator.next();
//                String key = entry.getKey();
//                String value = entry.getValue();
//                cache.invalidateAll();
//                System.out.printf("RandomInvalid key:%s, value:%s\n", key, value);
//            }
//        }).start();
//    }
//
//    private void startClean() {
//        new Thread(() -> {
//            while (true) {
//                cache.cleanUp();
//                System.out.println("clean up");
//                try {
//                    Thread.sleep(1_000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    private void startPutCache() {
//        int count = 10000;
//        while (count-- > 0) {
//            try {
//                String key = "1";
//                String value = null;
//                try {
//                    value = cache.get(key, () -> null);
//                } catch (Throwable t) {
////                    e.printStackTrace();
//                }
////                if (value == null) {
////                    cache.put(1 + "", count + "");
////                    System.out.println("put cache done. key:" + 1);
////                }
//                cache.put(count + "", count + "");
//                System.out.println("put cache done. key:" + count);
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
