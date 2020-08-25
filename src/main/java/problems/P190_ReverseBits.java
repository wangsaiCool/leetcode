package problems;

/**
 * Created by WangSai on 2020/8/25
 */
public class P190_ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        int count = 0;
        while (count++ < 32) {
            result <<= 1;
            result += n & 0x01;
            n >>= 1;
        }

        return result;
    }
}
