package problems;

import com.sun.media.sound.SoftTuning;

/**
 * Created by WangSai on 6/6/19
 *
 * 题目链接：https://leetcode.com/problems/move-zeroes/
 *
 * 题目描述：
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class P283_MoveZeroes {

    public void moveZeroesS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index=0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

    }

    public void moveZeroesS1(int[] nums) {
        int countZeros = 0;
        int[] marksArr = new int[nums.length];

        //统计0的个数, 非0数字标志为1
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (num == 0) {
                countZeros++;
            } else {
                marksArr[index] = 1;
                System.out.print(index + " ");
            }
        }

        //移动非0数字至数组左侧
        for (int i = 0; i < marksArr.length; i++) {
            if (marksArr[i] == 0) {
                for (int j = i + 1; j < marksArr.length; j++) {
                    if (marksArr[j] == 1) {
                        nums[i] = nums[j];
                        marksArr[j] = 0;
                        break;
                    }
                }
            }
        }

        //数组最后填充0
        while (countZeros > 0) {
            nums[nums.length - countZeros] = 0;
            countZeros--;
        }
    }

    public static void main(String[] args) {
        P283_MoveZeroes t = new P283_MoveZeroes();
        int[] nums = {0, 1, 0, 3, 12};
        t.moveZeroesS1(nums);
    }

}
