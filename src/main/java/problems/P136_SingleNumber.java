package problems;

/**
 * Created by WangSai on 6/6/19
 * 题目链接:https://leetcode.com/problems/single-number/
 *
 * 题目描述：
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class P136_SingleNumber {
    public int singleNumber(int[] nums) {
        int singleNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            singleNum ^= num;
        }
        return singleNum;
    }

    public static void main(String[] args) {
        P136_SingleNumber t = new P136_SingleNumber();
        int[] nums = {3,2,2};
        System.out.println(t.singleNumber(nums));

    }

}
