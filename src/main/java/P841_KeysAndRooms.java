import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 2/20/19
 */
public class P841_KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() <= 1) {
            return true;
        }
        boolean[] hasEntered = new boolean[rooms.size()];
        visitRooms(0, hasEntered, rooms);
        return !ArrayUtils.contains(hasEntered, false);
    }

    private void visitRooms(int roomNum, boolean[] hasEntered, List<List<Integer>> rooms) {
        if (roomNum >= rooms.size()) {
            throw new IllegalArgumentException("key error");
        }
        hasEntered[roomNum] = true;
        List<Integer> keys = rooms.get(roomNum);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) != -1) {

                System.out.println("keys.size=" + keys.size());
                visitRooms(keys.get(i), hasEntered, rooms);
                keys.set(i, -1);
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> keys_0 = new ArrayList<Integer>();
        List<List<Integer>> rooms = new ArrayList<List<Integer>>();
        keys_0.add(1);
        keys_0.add(3);
        rooms.add(keys_0);

        List<Integer> keys_1 = new ArrayList<Integer>();
        keys_1.clear();
        keys_1.add(3);
        keys_1.add(0);
        keys_1.add(1);
        rooms.add(keys_1);

        List<Integer> keys_2 = new ArrayList<Integer>();
        keys_2.clear();
        keys_2.add(2);
        rooms.add(keys_2);

        List<Integer> keys_3 = new ArrayList<Integer>();
        keys_3.clear();
        keys_3.add(0);
        rooms.add(keys_3);

        for (List<Integer> keyList : rooms) {
            for (Integer keyNum : keyList) {
                System.out.print(keyNum + " ");
            }
            System.out.println();
        }
        new P841_KeysAndRooms().canVisitAllRooms(rooms);
    }
}
