package chinese.sort;

import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;

import java.util.List;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by WangSai on 2023/4/11
 */
public class PinyiHoubbSortTest {
    private static final Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
    private static final com.ibm.icu.text.Collator collator = com.ibm.icu.text.Collator.getInstance(Locale.CHINESE);
    private static final int HANZI_UNICODE_START = 19968;
    private static final int HANZI_UNICODE_END = 40869;

    public static void main(String[] args) {
        PinyiHoubbSortTest hb = new PinyiHoubbSortTest();
        hb.testSort(ChineseConstants.RAW_CHINESE_LIST);
//        hb.printPinyin(ChineseConstants.RAW_CHINESE_LIST);
//        hb.checkCountName(ChineseConstants.RAW_CHINESE_LIST);
    }

    public void checkCountName(List<String> list) {
        list.forEach(s -> {
            Matcher m = p.matcher(s);
            boolean find = m.find();
            while (find) {
                MatchResult matchResult = m.toMatchResult();
                int start = matchResult.start();
                int end = matchResult.end();
                String substring = s.substring(start, end);

                System.out.println(s + " : " + find + " : " + substring);
                find = m.find();
            }
        });
    }

    private void testSort(List<String> list) {
        list.sort(this::compare2);
        list.forEach(System.out::println);
    }

    private void printPinyin(List<String> list) {
        list.forEach(s -> {
            String pinyin = PinyinHelper.toPinyin(s, PinyinStyleEnum.FIRST_LETTER, "");
            System.out.printf("%s : %s, rawSize:%s, newSize:%s\n", s, pinyin, s.length(), pinyin.length());
        });
    }

    /**
     * 按照数字、中文(首拼)、字母、其他字符顺序排序.
     *
     * @param s1
     * @param s2
     * @return
     */
    private int compare(String s1, String s2) {
        //中文转换为首拼, 其他字符保持原样. 如"abc-你好0539*👏"，会转换为"abc-nh0539*👏"
        String pinyin1 = PinyinHelper.toPinyin(s1, PinyinStyleEnum.FIRST_LETTER, StringUtil.EMPTY);
        String pinyin2 = PinyinHelper.toPinyin(s2, PinyinStyleEnum.FIRST_LETTER, StringUtil.EMPTY);
        int length = Math.min(s1.length(), s2.length());
        // 逐个字符比较, 如果是汉字则比较首字母
        for (int i = 0; i < length; i++) {
            char letter1 = pinyin1.charAt(i);
            char letter2 = pinyin2.charAt(i);
            if (letter1 == letter2) {
                continue;
            }

            int codePoint1 = s1.charAt(i);
            int codePoint2 = s2.charAt(i);
            // 数字排在最前
            int compare = collator.compare(String.valueOf(letter1), String.valueOf(letter2));
            if (Character.isDigit(codePoint1) && Character.isDigit(codePoint2)) {
                return compare;
            } else if (Character.isDigit(codePoint1)) {
                return -1;
            } else if (Character.isDigit(codePoint2)) {
                return 1;
            }

            // 汉字排第2位，按照首拼排序.
            if (isHanzi(codePoint1) && isHanzi(codePoint2)) {
                return compare;
            } else if (isHanzi(codePoint1)) {
                return Character.isDigit(codePoint2) ? 1 : -1;
            } else if (isHanzi(codePoint2)) {
                return Character.isDigit(codePoint1) ? -1 : 1;
            }

            // 字母排第3位.
            if (isLetter(codePoint1) && isLetter(codePoint2)) {
                return compare;
            } else if (isLetter(codePoint1)) {
                return isOthers(codePoint2) ? -1 : 1;
            } else if (isLetter(codePoint2)) {
                return isOthers(codePoint1) ? 1 : -1;
            }

            // 其他字符排序在最后.
            if (isOthers(codePoint1) && isOthers(codePoint2)) {
                return compare;
            } else if (isOthers(codePoint1)) {
                return 1;
            } else if (isOthers(codePoint2)) {
                return -1;
            }

            // 数字、字母的排序
            return compare;
        }
        // 前缀相同的字符串, 如"ab"、"abc"，较短的字符串排序在前.
        return Integer.compare(s1.length(), s2.length());
    }

    private boolean isHanzi(int hanzi) {
        return HANZI_UNICODE_START <= hanzi && hanzi <= HANZI_UNICODE_END;
    }

    private boolean isLetter(int letter) {
        return 'a' <= letter && letter <= 'z' || 'A' <= letter && letter <= 'Z';
    }

    private boolean isOthers(int other) {
        return !isHanzi(other) && !isLetter(other) && !Character.isDigit(other);
    }

    private int compare2(String s1, String s2) {
        //中文转换为首拼, 其他字符保持原样. 如"abc-你好"，会转换为"abc-nh"
        String pinyin1 = PinyinHelper.toPinyin(s1, PinyinStyleEnum.FIRST_LETTER, StringUtil.EMPTY);
        String pinyin2 = PinyinHelper.toPinyin(s2, PinyinStyleEnum.FIRST_LETTER, StringUtil.EMPTY);
        System.out.printf("s1:%s, s2:%s\np2:%s, p2:%s\n", s1, s2, pinyin1, pinyin2);
        int extracted = extracted(s1, s2, pinyin1, pinyin2);
        System.out.printf("r:%s\n===========================\n", extracted);
        return extracted;
    }

    private int extracted(String s1, String s2, String pinyin1, String pinyin2) {
        int length = Math.min(s1.length(), s2.length());
        // 逐个字符比较, 如果是汉字则比较首字母
        for (int i = 0; i < length; i++) {
            int codePoint1 = s1.charAt(i);
            int codePoint2 = s2.charAt(i);
            char letter1 = pinyin1.charAt(i);
            char letter2 = pinyin2.charAt(i);

            if (isHanzi(codePoint1) && isHanzi(codePoint2)) {
                // 汉字按照首拼进行排序
                if (letter1 != letter2) {
                    return collator.compare(letter1, letter2);
                }
            } else if (isHanzi(codePoint1)) {
                // 按照数字、字母在前，中文在后，其他字符排序在最后的顺序.
                return Character.isDigit(codePoint2) || Character.isLetter(codePoint2) ? 1 : -1;
            } else if (isHanzi(codePoint2)) {
                return Character.isDigit(codePoint1) || Character.isLetter(codePoint1) ? -1 : 1;
            }
            if (codePoint1 != codePoint2) {
                // 非中文采用默认排序方式
                return collator.compare(String.valueOf(s1.charAt(i)), String.valueOf(s2.charAt(i)));
            }
        }
        // 前缀相同的字符串, 如"ab"、"abc"，较短的字符串排序在前.
        return Integer.compare(s1.length(), s2.length());
    }

}
