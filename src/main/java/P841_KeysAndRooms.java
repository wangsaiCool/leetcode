import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by WangSai on 2/20/19
 */
public class P841_KeysAndRooms {
    public boolean canVisitAllRooms_Solution1(List<List<Integer>> rooms) {
        if (rooms.size() <= 1) {
            return true;
        }
        boolean[] hasEntered = new boolean[rooms.size()];
        visitRooms(0, hasEntered, rooms);
        return checkEnteredRoom(hasEntered);
    }

    public boolean canVisitAllRooms_Solution2(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int roomNum = stack.pop();
            for (int key : rooms.get(roomNum)) {
                if (!seen[key]) {
                    seen[key] = true;
                    stack.push(key);
                }
            }
        }
        return checkEnteredRoom(seen);
    }

    private boolean checkEnteredRoom(boolean[] hasEntered) {
        for (boolean result : hasEntered) {
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private void visitRooms(int roomNum, boolean[] hasEntered, List<List<Integer>> rooms) {
        if (roomNum >= rooms.size()) {
            throw new IllegalArgumentException("key error");
        }
        hasEntered[roomNum] = true;
        List<Integer> keys = rooms.get(roomNum);
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) != -1 && keys.size() > 0) {
                int key = keys.get(i);
                keys.set(i, -1);
                visitRooms(key, hasEntered, rooms);
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
        System.out.println(new P841_KeysAndRooms().canVisitAllRooms_Solution1(rooms));
        System.out.println(new P841_KeysAndRooms().canVisitAllRooms_Solution2(rooms));
    }
}
