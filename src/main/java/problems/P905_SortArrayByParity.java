package Problems;

/**
 * Created by WangSai on 10/16/18.
 */
public class P905_SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int num : A) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }
        return result;
    }
}
