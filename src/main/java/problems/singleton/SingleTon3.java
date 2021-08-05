package problems.singleton;

/**
 * 内部类的方式实现单例
 *
 * Created by WangSai on 2021/8/1
 */
public class SingleTon3 {
    private SingleTon3() {

    }

    private static class HOLDER {
        private static final SingleTon3 INSTANCE = new SingleTon3();
    }

    public static SingleTon3 getInstance() {
        return HOLDER.INSTANCE;
    }

}
