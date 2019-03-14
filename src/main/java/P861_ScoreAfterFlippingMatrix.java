/**
 * Created by WangSai on 2/21/19
 */
public class P861_ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
        return visitMatrix(A, 0, 0);
    }

    private static int visitMatrix(int[][] A, int rowIndex, int colmIndex) {
        int sum = calcScore(A);
        if (rowIndex<A.length-1) {
            sum = visitMatrix(A, rowIndex+1, colmIndex);
        }


        changeA(rowIndex,colmIndex,A);

        return 0;
    }

    private static void changeA(int rowIndex, int colmIndex, int[][] A) {
        //反转指定行rowIndex的值
        for (int colm = 0; colm < A[rowIndex].length; colm++) {
            A[rowIndex][colm] = 1 - A[rowIndex][colm];
        }

        //反转指定列 colmIndex的值
        for (int row = 0; row < A.length; row++) {
            A[row][colmIndex] = 1 - A[row][colmIndex];
        }
    }

    private static int calcScore(int[][] A) {
        int sum = 0;
        for (int rows = 0; rows < A.length; rows++) {
            int num = 0;
            for (int colms = 0; colms < A[rows].length; colms++) {
                num <<= 1;
                num += A[rows][colms];
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {1, 0, 0}, {0, 0, 1},};
        changeA(0, 0, A);
        printArray(A);
        System.out.println(calcScore(A));
    }

    private static void printArray(int[][] A) {
        System.out.println("{");
        for (int i = 0; i < A.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < A[i].length; j++) {
                System.out.print(A[i][j] + " , ");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }
}
