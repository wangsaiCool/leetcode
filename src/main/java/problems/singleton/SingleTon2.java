package problems.singleton;

/**
 * 双重检查锁
 *
 * Created by WangSai on 2021/8/1
 */
public class SingleTon2 {
    private static volatile SingleTon2 singleTon2 = null;

    public static SingleTon2 getInstance() {
        if (singleTon2 == null) {
            synchronized (SingleTon2.class) {
                if (singleTon2 == null) {
                    singleTon2 = new SingleTon2();

                }
            }
        }
        return singleTon2;
    }

    private SingleTon2() {
    }
}
