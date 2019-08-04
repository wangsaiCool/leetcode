package Problems;

import java.util.HashMap;

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

    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || t.length() != s.length()) {
            return false;
        }
        CountCharNum(s);
        HashMap<Character, Integer> sMap = CountCharNum(s);
        HashMap<Character, Integer> tMap = CountCharNum(t);

    }

    private HashMap<Character, Integer> CountCharNum(String s) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }
    }
}
