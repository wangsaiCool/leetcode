package problems.singleton;

/**
 * 饿汉模式实现单例
 * <p>
 * Created by WangSai on 2021/8/1
 */
class SingleTon1 {
    private static final SingleTon1 INSTANCE = new SingleTon1();

    private SingleTon1() {
    }

    public static SingleTon1 getInstance() {
        return INSTANCE;
    }
}
