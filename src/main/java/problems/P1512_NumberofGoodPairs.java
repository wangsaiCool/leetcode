package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2020/8/17
 */
public class P1512_NumberofGoodPairs {

    // 遍历，时间复杂度O(n*n)
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int outer = 0; outer < nums.length -1 ; outer++) {
            for (int inner = outer+1; inner < nums.length; inner++) {
                if (nums[outer] == nums[inner]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 数学排列组合，时间复杂度O(n)
    public int numIdenticalPairs2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        for (Integer  count: map.values()) {
            total += (count * (count - 1) / 2);
        }
        return total;

    }
}
