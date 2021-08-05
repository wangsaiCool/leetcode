package problems;

/**
 * Created by WangSai on 2019-05-21 22:46
 *
 * 题目链接：https://leetcode.com/problems/number-complement/
 *
 * 题目描述：
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */


public class P476_NumberComplement {
    public int findComplement(int num) {
        int result = 0;
        int index = 0;
        while (num > 0) {
            if ((num & 0x1) == 0x0) {
                result += Math.pow(2,index);
            }
            num >>= 1;
            index++;
        }
        return result;
    }

    public int findComplement2(int num) {
        int result = 0;
        int index = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                result += 1 << index;
            }
            index++;
            num >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        P476_NumberComplement p = new P476_NumberComplement();
        p.findComplement(2);
    }

}
