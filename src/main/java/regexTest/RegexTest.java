package regexTest;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WangSai on 2023/6/6
 */
public class RegexTest {

    public static void main(String[] args) {
        testRegex();
    }

    private static void testRegex() {
        String uri = "/t1/t2/{userId}/{id}";

        String result0 = StringUtils.replace(uri, "{\\w\\*}", "");
        System.out.println(result0);

        String result1 = replaceTarget(uri);
        System.out.println(result1);

        String result2 = replaceTarget(uri);
        System.out.println(result2);

        String result3 = replaceTarget("/t1/t2/{userId}");
        System.out.println(result3);

        String result4 = replaceTarget("/t1/t2");
        System.out.println(result4);

        String result5 = replaceTarget("");
        System.out.println(result5);
    }

    private static String replaceTarget(String uri) {
        Pattern p = Pattern.compile("/\\{\\w+\\}+");
        Matcher matcher = p.matcher(uri);
        return matcher.replaceAll("");
    }
}
