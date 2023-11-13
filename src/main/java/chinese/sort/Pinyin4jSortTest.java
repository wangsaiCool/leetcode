package chinese.sort;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 测试Pinyin4j多音字识别效果. 可以识别多音字，但是中英文会交叉排序
 * Created by WangSai on 2023/4/4
 */
public class Pinyin4jSortTest {
    private static final HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

    static {
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
    }

    public static void main(String[] args) {
        testSort(ChineseConstants.RAW_CHINESE_LIST);
//        printPinyin(ChineseConstants.RAW_CHINESE_LIST);
    }

    private static void printPinyin(List<String> list) {
        list.forEach(s -> {
            char[] ss = s.toCharArray();
            for (char c : ss) {
                String[] strings = new String[0];
                try {
                    strings = PinyinHelper.toHanyuPinyinStringArray(c, format);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
                Arrays.stream(strings).forEach(a -> System.out.println(a + " : " + c));
            }

        });
    }

    private static void testSort(List<String> list) {
        list.sort(Pinyin4jSortTest::compare);
        list.forEach(s -> {
            try {
                System.out.println(s + " : " + PinyinHelper.toHanYuPinyinString(s, format, "", true));
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        });
    }

    private static int compare(String o1, String o2) {
        try {
            com.ibm.icu.text.Collator collator1 = com.ibm.icu.text.Collator.getInstance(Locale.SIMPLIFIED_CHINESE);
            String p1 = PinyinHelper.toHanYuPinyinString(o1, format, "", true);
            String p2 = PinyinHelper.toHanYuPinyinString(o2, format, "", true);
            return collator1.compare(p1, p2);
//            return p1.compareTo(p2);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return 0;
    }

}
