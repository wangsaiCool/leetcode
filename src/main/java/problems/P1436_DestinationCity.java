package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WangSai on 2020/8/18
 */
public class P1436_DestinationCity {

    // 方法1：构建链表
    public String destCity(List<List<String>> paths) {
        LinkedList<String> linkedList = new LinkedList<>();


        for (int index = 0; index < paths.size(); index++) {
            for (List<String> path : paths) {
                String left = path.get(0);
                String right = path.get(1);
                if (linkedList.isEmpty()) {
                    linkedList.addLast(left);
                    linkedList.addLast(right);
                    continue;
                }
                if (linkedList.getFirst().equals(right)) {
                    linkedList.addFirst(left);
                } else if (linkedList.getLast().equals(left)) {
                    linkedList.addLast(right);
                }
            }
        }

        linkedList.forEach(System.out::println);
        return linkedList.getLast();

    }


    // 方法2：
    public String destCity2(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : paths) {
            map.put(pair.get(0), pair.get(1));
        }

        for (List<String> pair : paths) {
            if (!map.containsKey(pair.get(1))) {
                return pair.get(1);
            }
        }
        return null;
    }

    // 方法3：
    public String destCity3(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for (List<String> pair : paths) {
            set.add(pair.get(0));

        }

        for (List<String> pair : paths) {
            if (set.contains(pair.get(1))) {
                return pair.get(1);
            }
        }
        return null;
    }


    }
