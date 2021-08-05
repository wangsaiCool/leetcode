package problems;

import myUtils.ListNode;

/**
 * Created by WangSai on 2019-06-06 21:14
 *
 * 题目链接：https://leetcode.com/problems/reverse-linked-list/
 *
 * 题目描述：
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class P206_ReverseLinkedList {

    //solution1: iteratively
    public ListNode reverseListS1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //solution1: recursively
    public ListNode reverseListS2(ListNode head) {
        return reverseListS2(head, null);

    }

    private ListNode reverseListS2(ListNode now, ListNode pre) {
        if (now == null) {
            return pre;
        }

        ListNode next = now.next;
        now.next = pre;
        return reverseListS2(next, now);
    }

}
