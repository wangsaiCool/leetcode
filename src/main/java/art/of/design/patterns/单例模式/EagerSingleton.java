package art.of.design.patterns.单例模式;

/**
 * Created by WangSai on 2021/3/25
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
