package problems;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 *
 * Created by WangSai on 3/16/19.
 */
public class P944_DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = 0;
        for (int colmIndex = 0; colmIndex < A[0].length(); colmIndex++) {
            for (int wordIndex = 1; wordIndex < A.length; wordIndex++) {
                if (A[wordIndex - 1].charAt(colmIndex) - A[wordIndex].charAt(colmIndex) > 0) {
                    count++;
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {"zyx", "wvu", "tsr"};
        System.out.println(new P944_DeleteColumnstoMakeSorted().minDeletionSize(A));
    }
}
