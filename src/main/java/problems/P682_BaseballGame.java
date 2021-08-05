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
        int sum = 0;
        int listIndex = 0;
        int[] record = new int[ops.length];
        for (int index = 0; index < ops.length; index++) {
            String op = ops[index];
            if (op.equalsIgnoreCase("+")) {
                int now = record[listIndex - 2] + record[listIndex - 1];
                record[listIndex++] = now;
                sum += now;

            } else if (op.equalsIgnoreCase("D")) {
                int now = record[listIndex - 1] * 2;
                record[listIndex++] = now;
                sum += now;

            } else if (op.equalsIgnoreCase("C")) {
                int last = record[listIndex-- - 1];
                sum -= last;
            } else {
                int num = Integer.parseInt(op);
                record[listIndex++] = num;
                sum += num;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        String[] A = {"5", "2", "C", "D", "+"};
        int ret = new P682_BaseballGame().calPoints(A);
        System.out.println("result:" + ret);
        String[] B = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        ret = new P682_BaseballGame().calPoints(B);
        System.out.println("result:" + ret);
        String[] C = {"36", "28", "70", "65", "C", "+", "33", "-46", "84", "C"};
        int ret3 = new P682_BaseballGame().calPoints(C);
        System.out.println("result:" + ret3);
        String[] D = {"8373", "C", "9034", "-17523", "D", "1492", "7558", "-5022", "C", "C", "+", "+", "-16000", "C", "+", "-18694", "C", "C", "C", "-19377", "D", "-25250", "20356", "C", "-1769", "-8303", "C", "-25332", "29884", "C", "+", "C", "-29875", "-15374", "C", "+", "14584", "13773", "+", "17037", "-28248", "+", "16822", "D", "+", "+", "-19357", "-26593", "-8548", "4776", "D", "-8244", "378", "+", "-19269", "-25447", "18922", "-16782", "2886", "C", "-17788", "D", "-22256", "C", "308", "-9185", "-19074", "1528", "28424", "D", "8658", "C", "7221", "-13704", "8995", "-21650", "22567", "-29560", "D", "-9807", "25632", "6817", "28654", "D", "-18574", "C", "D", "20103", "7875", "C", "9911", "23951", "C", "D", "C", "+", "18219", "-20922", "D", "-24923"};
        int ret4 = new P682_BaseballGame().calPoints(D);
        System.out.println("result:" + ret4);
    }
}
