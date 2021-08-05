package problems;

/**
 * Created by WangSai on 8/9/18
 */
public class P832_FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int colm = A[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][colm - 1 - j];
                A[i][colm - 1 - j] = tmp;
            }
            for (int j = 0; j < colm; j++) {
                A[i][j] = 1 - A[i][j];
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        return A;
    }

    public static void main(String[] args) {
        P832_FlippingAnImage t = new P832_FlippingAnImage();
        int[][] A = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}};
        t.flipAndInvertImage(A);
    }
}
