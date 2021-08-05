package problems;

/**
 * Created by WangSai on 2019-06-26 23:56
 *
 * 题目链接：https://leetcode.com/problems/excel-sheet-column-number/
 *
 * 题目描述：
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *     Input: "A"
 *     Output: 1
 *
 * Example 2:
 *     Input: "AB"
 *     Output: 28
 *
 * Example 3:
 *     Input: "ZY"
 *     Output: 701
 */

public class P171_ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        char[] letters = s.toCharArray();
        int result = 0;
        for (int i = 0; i < letters.length; i++) {
            int base = letters[letters.length - i - 1] - 'A' + 1;
            result += Math.pow(26, i) * base;

        }
        return result;
    }

    public int titleToNumber2(String s) {
        char[] letters = s.toCharArray();
        int result = 0;
        for (int i = 0; i < letters.length; i++) {
            int base = letters[i] - 'A' + 1;
            result = result * 26 + base;

        }
        return result;
    }

    public static void main(String[] args) {
        P171_ExcelSheetColumnNumber p = new P171_ExcelSheetColumnNumber();
        System.out.println(p.titleToNumber("A"));
        System.out.println(p.titleToNumber("AA"));
        System.out.println(p.titleToNumber("AB"));
        System.out.println(p.titleToNumber2("BA"));

    }
}
