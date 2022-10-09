package myUtils;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WangSai on 2022/7/28
 */
public class TimeStampConvertor {
    private static final String RAW_TS_STR = "99508342920," +
            "99508342980," +
            "99508343040," +
            "99508343100," +
            "99508343160," +
            "99508343220," +
            "99508343280," +
            "99508343340," +
            "99508343400," +
            "99508343460," +
            "99508343520,";

    public static void main(String[] args) {
        String[] splits = StringUtils.splitPreserveAllTokens(RAW_TS_STR, ",");
        System.out.println("ts:date");
        for (String ts : splits) {
            if (StringUtils.isEmpty(ts)|| !StringUtils.isNumeric(ts)) {
                continue;
            }
            long realTimeStamp = Long.parseLong(ts) *  1000;
            String date = new SimpleDateFormat("MM-dd HH:mm").format(new Date(realTimeStamp));
            System.out.println(ts + " >> " + date);
        }
    }
}
