package chinese.sort;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.Collections;
import java.util.List;

/**
 * 中英文自定义排序
 *
 * Created by WangSai on 2023/4/4
 */
public class CustomSortTest {
    public static void main(String[] args) {
        List<String> list = ChineseConstants.RAW_CHINESE_LIST;
        Collections.sort(list, (o1, o2) -> compare(o1, o2));
        list.forEach(s-> System.out.println(s));

    }

    public static int compare(String o1, String o2) {
        for (int i = 0; i < o1.length() && i < o2.length(); i++) {
            char codePoint1 = o1.charAt(i);
            char codePoint2 = o2.charAt(i);

            //将汉字转换为拼音，不是汉子则为NULL
            String pinyin1 = pinyin(codePoint1);
            String pinyin2 = pinyin(codePoint2);
            //不为汉字则与原英文比较
            if (pinyin1 == null) {
                pinyin1 = (codePoint1 + "");
            }
            if (pinyin2 == null) {
                pinyin2 = (codePoint2 + "");
            }
            //忽略大小写比较
            if (!pinyin1.toLowerCase().equals(pinyin2.toLowerCase())) {
                return pinyin1.toLowerCase().compareTo(pinyin2.toLowerCase());
            } else {
                //不忽略大小写比较
                if (!pinyin1.equals(pinyin2)) {
                    return pinyin1.compareTo(pinyin2);
                }
            }
        }
        return o1.length() - o2.length();
    }

    /**
     * 字符的拼音，多音字就得到第一个拼音。不是汉字，就return null。
     */
    private static String pinyin(char c) {
        String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c);
        if (pinyins == null) {
            return null;
        }
        return pinyins[0];
    }

}
