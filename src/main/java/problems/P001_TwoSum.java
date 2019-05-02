package problems;

import java.util.HashMap;

public class P001_TwoSum {
    public int[] twoSum_solution1(int[] nums, int target) {
        if (nums.length <= 0) {
            return null;
        }
        for (int low = 0; low < nums.length - 1; low++) {
            for (int hi = low + 1; hi < nums.length; hi++) {
                int sum = nums[low] + nums[hi];
                if (sum == target) {
                    return new int[]{low, hi};
                }

            }

        }
        return null;
    }

    public int[] twoSum(int[] nums,int target){
        HashMap<Integer,Integer> record = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            record.put(nums[index],index);
        }
        for (int index = 0; index < nums.length; index++) {
           int remaining = target - nums[index];
           if (record.containsKey(remaining)&& record.get(remaining)!=index){
               return new int[]{index,record.get(remaining)};
           }
        }
        throw  new IllegalArgumentException("no such nums");
    }

    public static void main(String[] args) {
        int[] ret = new P001_TwoSum().twoSum_solution1(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ret[0]);
        System.out.println(ret[1]);

        ret = new P001_TwoSum().twoSum_solution1(new int[]{3, 2, 4}, 6);
        System.out.println(ret[0]);
        System.out.println(ret[1]);


        ret = new P001_TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(ret[0]);
        System.out.println(ret[1]);

        ret = new P001_TwoSum().twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

}
