package problems;

/**
 * Created by WangSai on 2020/8/16
 */
public class P1470_ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];

        n = n % nums.length;
        if (n == 1) {
            return nums;
        }


        for (int index = 0; index < nums.length / 2; index++) {
            result[index * 2] = nums[index];
            result[index * 2 + 1] = nums[index + n];
        }

        return result;
    }
}
