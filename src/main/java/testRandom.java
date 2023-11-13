import java.util.Random;

/**
 * Created by WangSai on 2023/4/19
 */
public class testRandom {
    private static final Random rand1 = new Random(10);
    private static final Random rand2 = new Random(10);
    private static long pre = 10;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand1.nextInt() + ":" + rand2.nextInt());
        }
        Math.random();
        for (int i = 0; i < 10; i++) {
            System.out.println(nextInt(10));
        }
    }

    private static int nextInt(int bound) {
        long current = pre * 31415926536L;
        pre = current;
        return (int) Math.abs(current) % bound;
    }
}
