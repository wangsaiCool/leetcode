package art.of.design.patterns.单例模式;

/**
 * Created by WangSai on 2021/3/25
 */
public class IoDHSingleton {

    private IoDHSingleton() {

    }

    private static class SingletonHolder {
        private static final IoDHSingleton INSTANCE = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
