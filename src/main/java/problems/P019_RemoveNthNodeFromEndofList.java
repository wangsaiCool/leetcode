package Problems;

import myUtils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WangSai on 2019-05-06 23:36
 *
 * 题目链接：https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 *
 * 题目描述：
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */

public class P019_RemoveNthNodeFromEndofList {

    //两个指针,遍历1遍
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null || head.next == null && n == 1) {
            return null;
        }

        ListNode fastStep = head;
        ListNode slowStep = head;

        while (fastStep.next != null && n-- >0) {
            fastStep = fastStep.next;

        }

        //检查链表长度
        if (n>0){
            return null;
        }

        while (fastStep.next!=null){
            fastStep = fastStep.next;
            slowStep = slowStep.next;
        }

        slowStep.next = fastStep;
        return head;

    }

    //遍历两遍
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        int count = 0;
        ListNode ref = head;
        while (ref != null) {
            ref = ref.next;
            count++;
        }


        if (count < n) {
            return null;
        }
        if (count == n) {
            return head.next;
        }

        count -= n;
        ref = head;


        while (--count > 0) {
            ref = ref.next;
        }
        ref.next = ref.next.next;

        return head;
    }
}
