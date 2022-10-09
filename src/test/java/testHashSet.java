import java.util.HashSet;
import java.util.Set;

/**
 * Created by WangSai on 2022/7/1
 */
public class testHashSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add(new String("test"));
        if (set.contains("test")) {
            System.out.println(true);
        }
        if (set.contains(new StringBuilder("test").toString())) {

            System.out.println(true);
        }
    }
}
