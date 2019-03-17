package problems;

/**
 * https://leetcode.com/problems/n-repeated-element-in-size-2n-array/submissions/
 * Created by WangSai on 3/17/19.
 */
public class P961_NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        int num = 0;
        int[] result = new int[1000];
        for (int index = 0; index < A.length; index++) {
            if (result[A[index]]++ == 1) {
                num = A[index];
                break;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};
        System.out.println(new P961_NRepeatedElementinSize2NArray().repeatedNTimes(A));
        int[] B = {2, 1, 2, 5, 3, 2};
        System.out.println(new P961_NRepeatedElementinSize2NArray().repeatedNTimes(B));
        int[] C = {1, 6, 6, 9};
        System.out.println(new P961_NRepeatedElementinSize2NArray().repeatedNTimes(C));
        int[] D = {3, 5, 1, 5, 2, 5, 3, 5, 4};
        System.out.println(new P961_NRepeatedElementinSize2NArray().repeatedNTimes(D));
    }
}
