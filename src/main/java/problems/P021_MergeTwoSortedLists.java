package problems;

import myUtils.ListNode;

/**
 * 题目链接:https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Created by WangSai on 11/15/19
 */
public class P021_MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode newListNode = head;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                newListNode = new ListNode(l1.val);
                l1 = l1.next;
            }else{

            }
        }
    }
}
