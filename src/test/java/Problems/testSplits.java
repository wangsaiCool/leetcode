package Problems;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by WangSai on 2022/11/15
 */
public class testSplits {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
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
