package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 2019-08-14 22:13
 *
 * 题目链接：https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * 题目描述：
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

public class P448_FindAllNumbersDisappearedinanArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num != i + 1) {
                if (num == nums[num - 1]) {
                    break;
                }
                swap(nums, i, num - 1);
                num = nums[i];
            }
        }

        //check nums[i]==i+1 ?
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
