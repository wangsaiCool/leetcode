package art.of.design.patterns.singleton;

/**
 * Created by WangSai on 2021/3/25
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;
    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (null == instance) {
            synchronized (LazySingleton.class) {
                if (null == instance) {
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }
}
