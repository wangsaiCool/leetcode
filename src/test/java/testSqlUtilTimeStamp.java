import java.sql.Timestamp;

/**
 * Created by WangSai on 2022/11/7
 */
public class testSqlUtilTimeStamp {
    public static void main(String[] args) {

        long v = Long.parseLong("100_00");
        System.out.println(v);
    }

    private static void printBits(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num & 0x01);
            num >>>= 1;
        }
        System.out.println(sb.reverse().toString());
    }
}
