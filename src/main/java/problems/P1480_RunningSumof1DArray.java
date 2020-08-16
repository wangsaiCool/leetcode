package problems;

/**
 * Created by WangSai on 2020/8/16
 */
public class P1480_RunningSumof1DArray {

    public int[] runningSum1(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 0;
        for (int index = 0; index < nums.length; index++) {
            sum += nums[index];
            result[index] = sum;
        }
        return result;
    }

    public int[] runningSum(int[] nums) {
        for (int index = 1; index < nums.length; index++) {
            nums[index] += nums[index - 1];
        }
        return nums;
    }

}
