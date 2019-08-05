package Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2019-06-28 18:01
 *
 * 题目链接：https://leetcode.com/problems/valid-anagram/
 *
 * 题目描述：
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class P242_ValidAnagram {

    //map
    public boolean isAnagram1(String s, String t) {
        if (t == null || s == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char sKey = s.charAt(i);
            if (sMap.containsKey(sKey)) {
                sMap.put(sKey, sMap.get(sKey) + 1);
            } else {
                sMap.put(sKey, 1);
            }

            char tKey = t.charAt(i);
            if (tMap.containsKey(tKey)) {
                tMap.put(tKey, tMap.get(tKey) + 1);
            } else {
                tMap.put(tKey, 1);
            }

        }

        for (Map.Entry<Character, Integer> kv : sMap.entrySet()) {
            Character sKey = kv.getKey();
            Integer sValue = kv.getValue();

            if (!tMap.containsKey(sKey)) {
                return false;
            } else {
                int tValue = tMap.get(sKey);
                if (sValue != tValue) {
                    return false;
                }
            }
        }

        return true;
    }

    //int[] arr
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        int[] ss = new int[26];
        int[] tt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char sSub = s.charAt(i);
            char tSub = t.charAt(i);
            ss[sSub - 'a']++;
            tt[tSub - 'a']++;

        }

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i]) {
                return false;
            }
        }
        return true;

    }


}
