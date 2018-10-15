import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 10/15/18.
 */
public class P728_SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        if (left >= right) {
            return result;
        }
        for (int i = left; i <= right; i++) {
            if (selfDividedNum(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean selfDividedNum(int num) {
        if (num <= 0) {
            return false;
        }
        int remain = num % 10;
        int result = num / 10;
        while (remain > 0 && num % remain == 0) {
            remain = result % 10;
            result = result / 10;
        }
        if (remain == 0 && result == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P728_SelfDividingNumbers t = new P728_SelfDividingNumbers();
        List<Integer> result = t.selfDividingNumbers(1, 22);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
