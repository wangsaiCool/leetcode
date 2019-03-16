package problems;

/**
 * Created by WangSai on 3/16/19.
 * Given a matrix A, return the transpose of A.
 * <p>
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 * <p>
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class P867_TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int rowA = A.length;
        int colA = A[0].length;

        int[][] result = new int[colA][rowA];

        for (int rowAindex = 0; rowAindex < rowA; rowAindex++) {
            for (int colAindex = 0; colAindex < colA; colAindex++) {
                int num = A[rowAindex][colAindex];
                result[colAindex][rowAindex] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        int[][] result = new P867_TransposeMatrix().transpose(A);
        for (int i = 0; i < result.length; i++) {
            System.out.println();
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }
}
