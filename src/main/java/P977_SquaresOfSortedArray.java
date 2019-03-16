/**
 * Created by WangSai on 3/16/19.
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 * <p>
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class P977_SquaresOfSortedArray {

    public int[] sortedSquares(int[] A) {
        int loIndex = 0;
        int hiIndex = A.length - 1;
        int[] result = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            int loValue = A[loIndex] * A[loIndex];
            int hiValue = A[hiIndex] * A[hiIndex];
            if (hiValue > loValue) {
                result[i] = hiValue;
                hiIndex--;
            } else {
                result[i] = loValue;
                loIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        int[] ret = new P977_SquaresOfSortedArray().sortedSquares(A);
        for (int index = 0; index < ret.length; index++) {
            System.out.print(ret[index] + " ");
        }
    }


}
