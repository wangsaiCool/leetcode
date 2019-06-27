package Problems;

/**
 * Created by WangSai on 2019-06-27 22:56
 *
 * 题目链接：https://leetcode.com/problems/missing-number/
 *
 * 题目描述：
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class P268_MissingNumber {

    //时间复杂度O(n)
    public int missingNumber(int[] nums) {
        int[] mark = new int[nums.length + 1];
        for (int num : nums) {
            mark[num] = -1;
        }

        for (int i = 0; i < mark.length; i++) {
            if (mark[i] == 0) {
                return i;
            }
        }

        return 0;
    }

    /**
     * 时间复杂度o(n)
     *
     * 通过异或的方式计算, a^b^b=a
     * 假设数组长度是3，数组位{0,1,3}，角标数字和数组数字如下：
     * 0 0
     * 1 1
     * 2 3
     * 缺少的数字是2。所以根据异或原理，只要再有一个数字3(即等于数组长度)，即可根据异或原理求得缺少的数字2.
     */
    public int missingNumber2(int[] nums) {
        int ret = nums.length;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        P268_MissingNumber p = new P268_MissingNumber();
        System.out.println(p.missingNumber2(new int[] {0, 1, 2, 4}));

    }
}
