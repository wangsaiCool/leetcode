package art.of.design.patterns.单例模式;

/**
 * Created by WangSai on 2021/3/25
 */
public class LazySingleton {

    // 为了保证可见性， 需要使用volatile
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
