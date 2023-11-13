package optional;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by WangSai on 2023/6/20
 */
public class OptionalTest {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(mergedUris(new String[]{}, new String[]{})));
        System.out.println(Arrays.toString(mergedUris(new String[]{}, new String[]{"1"})));
        System.out.println(Arrays.toString(mergedUris(new String[]{"2"}, new String[]{})));
        System.out.println(Arrays.toString(mergedUris(new String[]{"1"}, new String[]{"1"})));
        System.out.println(Arrays.toString(mergedUris(new String[]{"1"}, new String[]{"2"})));
        System.out.println(Arrays.toString(mergedUris(new String[] {"1"}, new String[] {"1", "2", "3"})));
    }

    private static String[] mergedUris(String[] oldIds, String[] newIds) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(oldIds));
        set.addAll(Arrays.asList(newIds));
        return set.toArray(new String[0]);
    }


    private static long[] mergeArrays(long[] oldIds, long[] newIds) {
        long[] mergedArray = new long[oldIds.length + newIds.length];

        System.arraycopy(oldIds, 0, mergedArray, 0, oldIds.length);
        System.arraycopy(newIds, 0, mergedArray, oldIds.length, newIds.length);

        return mergedArray;
    }

}
