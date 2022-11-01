import java.sql.Timestamp;

/**
 * Created by WangSai on 2022/11/7
 */
public class testSqlUtilTimeStamp {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        Timestamp ts = new Timestamp(now);
        System.out.println(ts.toString());

    }
}
