package Problems;

/**
 * Created by WangSai on 2019-05-12 23:49
 * <p>
 * 题目链接：
 * https://leetcode.com/problems/array-partition-i/
 */


public class P561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        //Arrays.sort(nums);
        QSorted(nums);
        int ret = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            ret += nums[i];
        }
        return ret;

    }


    private int[] QSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        return QSorted(nums, 0, nums.length - 1);
    }

    private int[] QSorted(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pos = getPartionPos(nums, lo, hi);
            QSorted(nums, lo, pos - 1);
            QSorted(nums, pos + 1, hi);
        }
        return nums;
    }

    private int getPartionPos(int[] nums, int lo, int hi) {
        int value = nums[lo];

        while (lo < hi) {
            while (lo < hi && value <= nums[hi]) {
                hi--;
            }
            nums[lo] = nums[hi];

            while (lo < hi && value >= nums[lo]) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = value;
        return lo;

    }
}
