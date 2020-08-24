package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WangSai on 2020/8/24
 */
public class P118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        if (numRows == 0) {
            return result;
        }
        List<Integer> content = Arrays.asList(1);
        result.add(content);
        if (1 == numRows) {
            return result;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> top = result.get(result.size() - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < top.size(); j++) {
                current.add(top.get(j - 1) + top.get(j));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
