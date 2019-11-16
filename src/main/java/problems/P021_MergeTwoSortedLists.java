package Problems;

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
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        while (l1 != null) {
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            pre.next = l2;
            pre = pre.next;
            l2 = l2.next;
        }

        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode pre = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (pre == null) {
                    head = new ListNode(l1.val);
                    pre = head;
                } else {
                    pre.next = new ListNode(l1.val);
                    pre = pre.next;
                }
                l1 = l1.next;
            } else {
                if (pre == null) {
                    head = new ListNode(l2.val);
                    pre = head;
                } else {
                    pre.next = new ListNode(l2.val);
                    pre = pre.next;
                }
                l2 = l2.next;

            }
        }

        while (l1 != null) {
            pre.next = new ListNode(l1.val);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            pre.next = new ListNode(l2.val);
            pre = pre.next;
            l2 = l2.next;
        }
        return head;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists3(l1, l2.next);
            return l2;
        }

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode r10 = new ListNode(10);
        ListNode r11 = new ListNode(11);
        ListNode r12 = new ListNode(12);
        r10.next = r11;
        r11.next = r12;

        P021_MergeTwoSortedLists test = new P021_MergeTwoSortedLists();
        ListNode ret = test.mergeTwoLists2(l1, r10);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
    }
}
