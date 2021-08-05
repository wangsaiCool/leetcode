package problems;

/**
 * Created by WangSai on 2019-06-18 22:57
 *
 * 题目链接：https://leetcode.com/problems/majority-element/
 *
 * 题目描述：
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */

public class P169_MajorityElement {

    //思路
    // more than ⌊ n/2 ⌋ times的意思，是统计数组中出现次数超过一半的数字，这个数字是majority element
    public int majorityElement(int[] nums) {
        int count=0;
        int result =0;
        for (int num : nums) {
            if (count == 0) {
                result = num;
                count = 1;
                continue;
            }

            if (num == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
}
