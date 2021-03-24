package concurrencyInPractice.hashMap;

import java.util.HashMap;

/**
 * Created by WangSai on 2021/2/27
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Inner, String> map = new HashMap(100) {
            @Override
            public int hashCode() {
                return 200;
            }
        };

        for (int i = 0; i < 100; i++) {
            map.put(new Inner(i), "v1_" + i);
        }

        for (int i = 0; i < 100; i++) {
            map.put(new Inner(2), "v1_" + i);
        }

        map.hashCode();
        String s = "123";
        s.hashCode();
    }

    private static class Inner{
        int value;

        public Inner(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return value;
        }

    }
}
