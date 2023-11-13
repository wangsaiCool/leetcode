package Problems;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by WangSai on 2022/11/15
 */
public class testSplits {

    public static void main(String[] args) {
        List<Integer> list = Collections.emptyList();

        for (Integer num : list) {
            System.out.println(num);
        }
//        float w1 = 1.1f;
//        long t1 = 20000;
//        System.out.println(w1 * t1);
//        System.out.println(1.00000000001f < 1.00000000002f);
//        System.out.println(1.1d == 1.2d);
//        System.out.println(System.currentTimeMillis());
//        String FLAG = "-c-";
//        String[] targets = {"1212312-c-1", "1212312-c-", "1212312-r-", "1212312-", "1212312"};
//        for (String t : targets) {
//            test(FLAG, t);
//        }

    }

    private static void test(String FLAG, String target) {
        String[] splits = StringUtils.splitByWholeSeparator(target, FLAG);
        System.out.println("=============================");
        System.out.println("now: " + target);
        System.out.println(splits.length);
        if (splits.length != 2) {
            System.out.println("unexpected. size:" + splits.length);
            return;
        }
        System.out.println(splits[1]);

    }
}
