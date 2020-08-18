package problems;

/**
 * Created by WangSai on 2020/8/18
 */
public class P1450_NumberofStudentsDoingHomeworkataGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        if (startTime.length == 0 || endTime.length == 0 || startTime.length != endTime.length) {
            return 0;
        }

        int count = 0;
        for (int index = 0; index < startTime.length; index++) {
            if (startTime[index] <= queryTime && queryTime <= endTime[index]) {
                count++;
            }
        }
        return count;
    }
}
