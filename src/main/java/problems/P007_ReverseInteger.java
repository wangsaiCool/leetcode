package Problems;

/**
 * Created by WangSai on 2019-10-23 23:02
 *
 * 题目链接: https://leetcode.com/problems/reverse-integer/
 *
 * 题目描述: given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */

public class P007_ReverseInteger {

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int newResult = result * 10 + x % 10;
            // 判断是否反转后的数字溢出了
            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;

    }

    public static void main(String[] args) {
        int x = Integer.MAX_VALUE + 2;
        int result = new P007_ReverseInteger().reverse(x);
        System.out.println(result);

        x = 123;
        result = new P007_ReverseInteger().reverse(x);
        System.out.println(result);
        x = -100300;
        result = new P007_ReverseInteger().reverse(x);
        System.out.println(result);

        x= 1534236469;
        System.out.println(new P007_ReverseInteger().reverse(x));
    }

}
