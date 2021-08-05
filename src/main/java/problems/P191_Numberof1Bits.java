package problems;

/**
 * Created by WangSai on 2019-06-24 22:29
 *
 * 题目链接：https://leetcode.com/problems/number-of-1-bits/
 *
 * 题目描述：
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 */

public class P191_Numberof1Bits {

    //无符号右移
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 0x1;
            n >>>= 1;
        }
        return count;

    }

    //反转最后一位的1
    public int hammingWeight2(int n) {
        int ones = 0;
        while (n != 0) {
            n = n & (n - 1);
            ones++;
        }
        return ones;

    }

    public static void main(String[] args) {
        P191_Numberof1Bits p = new P191_Numberof1Bits();
        System.out.println(p.hammingWeight1(1));
        System.out.println(p.hammingWeight1(2));
        System.out.println(p.hammingWeight1(-3));
        System.out.println(p.hammingWeight2(-3));

    }
}
