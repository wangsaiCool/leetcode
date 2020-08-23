package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2020/8/23
 */
public class P387_FirstUniqueCharacterinaString {

    // 将字符转换为新数组的角标，新数组记录字符出现的次数
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] indexRecord = new int[256];
        Arrays.fill(indexRecord, -1);
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (indexRecord[letter] == -1) {
                indexRecord[letter] = i;
            } else {
                indexRecord[letter] = -2;
            }
        }

        int minIndex = s.length();
        for (int i = 0; i < indexRecord.length; i++) {
            int index = indexRecord[i];
            if (index >= 0 && index < minIndex) {
                minIndex = index;
            }
        }
        return minIndex == indexRecord.length ? -1 : minIndex;
    }

    // 借助hashMap
    public int firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (hashMap.containsKey(letter)) {
                hashMap.put(letter, hashMap.get(letter) + 1);
            } else {
                hashMap.put(letter, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (hashMap.get(letter) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 统计字符出现的次数，改进方法
    public int firstUniqChar3(String s) {
        int[] countLetter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            countLetter[s.charAt(i)]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (countLetter[s.charAt(i)] == 0) {
                return i;
            }
        }
        return -1;
    }
}
