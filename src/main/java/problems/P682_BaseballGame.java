package problems;

/**
 * Created by WangSai on 3/16/19.
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * <p>
 * You need to return the sum of the points you could get in all the rounds.
 */
public class P682_BaseballGame {
    public int calPoints(String[] ops) {
        int pointL = 0;
        int pointM = 0;
        int pointR = 0;
        int sum = 0;

        for (int index = 0; index < ops.length; index++) {
            String op = ops[index];
            System.out.println("=================================");
            System.out.printf("处理之前, pointL={%d},pointM={%d},pointR={%d}\n", pointL, pointM, pointR);
            System.out.printf("当前处理的op[%d]:%s\n", index, op);
            if (op.equalsIgnoreCase("+")) {
                pointL = pointM;
                pointM = pointR;
                pointR = pointL + pointM;
                sum += pointR;
                System.out.printf("处理之后, pointL={%d},pointM={%d},pointR={%d}\n", pointL, pointM, pointR);
            } else if (op.equalsIgnoreCase("D")) {
                pointL = pointM;
                pointM = pointR;
                pointR = pointM * 2;
                sum += pointR;
                System.out.printf("处理之后, pointL={%d},pointM={%d},pointR={%d}\n", pointL, pointM, pointR);
            } else if (op.equalsIgnoreCase("C")) {
                sum -= pointR;
                pointR = pointM;
                pointM = pointL;
                System.out.printf("处理之后, pointL={%d},pointM={%d},pointR={%d}\n", pointL, pointM, pointR);
            } else {
                int num = Integer.parseInt(op);
                pointL = pointM;
                pointM = pointR;
                pointR = num;
                sum += pointR;
                System.out.printf("处理之后, pointL={%d},pointM={%d},pointR={%d}\n", pointL, pointM, pointR);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
//        String[] A = {"5", "2", "C", "D", "+"};
//        int ret = new P682_BaseballGame().calPoints(A);
//        System.out.println("result:" + ret);
//        String[] B = {"5", "-2", "4", "C", "D", "9", "+", "+"};
//        ret = new P682_BaseballGame().calPoints(B);
//        System.out.println("result:" + ret);
        String[] C = {"36", "28", "70", "65", "C", "+", "33", "-46", "84", "C"};
        int ret3 = new P682_BaseballGame().calPoints(C);
        System.out.println("result:" + ret3);
    }
}
