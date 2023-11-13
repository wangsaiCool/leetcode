package barrierTest;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2023/6/2
 */
public class BarrierMain {
    public static void main(String[] args) {
//        BarrierType type = BarrierType.valueOf("GalleryApi");
//        System.out.println(type);
//
//        System.out.println(BarrierType.GalleryApi);
//        System.out.println(BarrierType.GalleryApi.getBarrierType());
//        Map<Short, Integer> levelAndRateMap = new HashMap<>();
//        Short[] barrierLevel1 = levelAndRateMap.keySet().toArray(new Short[0]);
//        System.out.println(barrierLevel1.length);
//
//
//        levelAndRateMap.put((short)1, 2);
//        levelAndRateMap.put((short)3, 4);
//        Short[] barrierLevel2 = levelAndRateMap.keySet().toArray(new Short[0]);
//        System.out.println(barrierLevel2.length);
        String[] ids = new String[] {"1", "2", "3"};
        System.out.println(ArrayUtils.contains(ids, new StringBuilder().append("1").toString()));
        BarrierMain m = new BarrierMain();
        Test t1 = m.new Test();
        Test t2 = m.new Test();
        System.out.println(t1 == t2);
        System.out.println(t1.equals(t2));
    }

    public class Test {
        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

}
