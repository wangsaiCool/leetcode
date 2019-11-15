package problems;

/**
 * Created by WangSai on 8/14/19
 *
 * 题目链接：https://leetcode.com/problems/roman-to-integer/
 *
 * 题目描述：按照罗马数字的计算规则，把罗马数字转为十进制数字.
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class P013_RomantoInteger {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] letters = s.toCharArray();
        int result = 0;
        for (int index = 0; index < letters.length; index++) {
            //IVX,XLC,CDM
            char roman = letters[index];
            int num = convert(roman);
            if (index + 1 < letters.length && num < convert(letters[index + 1])) {
                result -= num;
            } else {
                result += num;
            }
        }
        return result;
    }

    private int convert(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;

        }
    }

    public static void main(String[] args) {
        P013_RomantoInteger tool = new P013_RomantoInteger();
        System.out.println(tool.romanToInt("IV"));

    }
}
