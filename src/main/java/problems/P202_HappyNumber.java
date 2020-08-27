package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangSai on 2020/8/27
 */
public class P202_HappyNumber {

    public boolean isHappy(int num) {
        Set<Integer> set = new HashSet<>();
        while (num != 1 && !isCycle(set, num)) {
            num = getSum(num);
        }

        return num == 1;
    }

    private int getSum(int num) {
        int sum = 0;

        while (num > 0) {
            int remaining = num % 10;
            sum += remaining * remaining;
            num = num / 10;
        }
        return sum;
    }

    private boolean isCycle(Set<Integer> set, int n) {
        if (set.contains(n)) {
            return true;
        } else {
            set.add(n);
            return false;
        }
    }
}
