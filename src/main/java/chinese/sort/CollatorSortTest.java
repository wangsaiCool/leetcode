package chinese.sort;

import com.ibm.icu.util.ULocale;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 对比java.text.RuleBasedCollator和com.ibm.icu.text.Collator生僻字识别效果:
 * 前者可实现排序，但是无法识别生僻字
 * 后者生僻字识别效果很好， 但是中文会排在英文后面
 *
 * Created by WangSai on 2023/3/15
 */
public class CollatorSortTest {
    public static void main(String[] args) {
//        testJavaNativeSort(ChineseConstants.RAW_CHINESE_LIST);
        testIbmSort(ChineseConstants.RAW_CHINESE_LIST);
    }

    private static void testJavaNativeSort(List<String> list) {
        System.out.println("==================testJavaNativeSort==============");
        java.text.Collator collator = java.text.RuleBasedCollator.getInstance(Locale.SIMPLIFIED_CHINESE);
        Collections.shuffle(list);
        Collections.sort(list, (o1, o2) -> collator.compare(o1, o2));
        list.forEach(c -> System.out.println(c + " "));
    }

    private static void testIbmSort(List<String> list) {
        com.ibm.icu.text.Collator collator1 = com.ibm.icu.text.Collator.getInstance(Locale.SIMPLIFIED_CHINESE);
        Collections.shuffle(list);

        System.out.println("==================testIbmSort 1==============");
        Collections.sort(list, (o1, o2) -> collator1.compare(o1, o2));
        list.forEach(c -> System.out.println(c + " "));

        System.out.println("==================testIbmSort 2==============");
        com.ibm.icu.text.Collator collator2 = com.ibm.icu.text.Collator.getInstance(ULocale.CHINA);
        Collections.sort(list, (o1, o2) -> collator2.getCollationKey(o1).compareTo(collator2.getCollationKey(o2)));
        list.forEach(c -> System.out.println(c + " "));
    }

    private static final List<String> list = Arrays.asList(
            "1", "2", "长大", "长短", "长久", "厂家", "单个人", "单田芳", "虾-x",
            "生-s", "远方", "省长", "省悟", "安倍", "钛媒体", "网易汽车", "昕薇网", "新民汽车网",
            "瘾科技", "中国", "中心",
            "但呀", "但吖", "但在", "但一次", "但再", "但是", "当啊", "国家2", "國家1", "國家",
            "啊", "本", "邸达", "犇犇", "本啊", "过去", "吖", "dan1", "dan2", "DAN1", "DAN3", "1"
    );

}