package Problems;

import java.util.*;

/**
 * Created by WangSai on 2019-05-16 00:18
 * 题目链接：https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * 题目描述：
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */


public class P349_IntersectionofTwoArrays {

    //两个指针的方式
    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        int count = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;

            } else if (nums1[index1] > nums2[index2]) {
                index2++;

            } else {
                if (list.size() == 0 || list.get(count-1) != nums1[index1]) {
                    count++;
                    list.add(nums1[index1]);
                }
                index1++;
                index2++;
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;

    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Set<Integer> set = new HashSet<Integer>();
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1++;

            } else if (nums1[index1] > nums2[index2]) {
                index2++;

            } else {
                set.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int[] ret = new int[set.size()];
       int count = 0;
        for (Integer num : set        ) {
            ret[count++] = num;
        }
        return ret;

    }

    //hashSet
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                intersectionSet.add(nums2[i]);
            }
        }
        int count = 0;
        int[] ret = new int[intersectionSet.size()];
        for (Integer num : intersectionSet) {
            ret[count++] = num;

        }
        return ret;
    }
}
