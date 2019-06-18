package Problems;

import java.util.HashSet;

/**
 * Created by WangSai on 2019-06-18 23:20
 *
 * 题目链接:https://leetcode.com/problems/contains-duplicate/
 *
 * 题目描述:
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */

public class P217_ContainsDuplicate {

    //时间复杂度O(n^2)，空间复杂度O(1）的解法
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //时间复杂度O(n)，空间复杂度o(n)
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    //时间复杂度O(n)，空间复杂度o(1)
    public boolean containsDuplicate3(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
            if (result == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(2^1);
        int[] nums = {1, 2, 3, 4};
        boolean ret = new P217_ContainsDuplicate().containsDuplicate3(nums);
        System.out.println(ret);

    }
}
