package Problems;

/**
 * Created by WangSai on 2019-05-12 01:41
 * 题目链接：https://leetcode.com/problems/binary-gap/
 *
 * 题目描述：
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 *
 * If there aren't two consecutive 1's, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 *
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 *
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 *
 *
 * Note:
 *
 * 1 <= N <= 10^9
 */


public class P868_BinaryGap {
    public int binaryGap(int N) {
        int lastIndex = 0;
        int nowIndex = 0;
        int max = 0;

        while (N > 0) {
            nowIndex++;

            if ((N & 1) == 1) {
                if (lastIndex == 0) {
                    lastIndex = nowIndex;
                    N >>=1;
                    continue;
                }

                int diff = nowIndex - lastIndex;
                if (diff > max) {
                    max = diff;

                }
                lastIndex = nowIndex;
            }

            N >>= 1;
        }
        return max;
    }
}
