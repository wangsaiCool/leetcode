package problems;

import myUtils.ListNode;

/**
 * 题目链接:  https://leetcode.com/problemset/algorithms/?listId=wpwgkgt
 * Created by WangSai on 2019-11-17 12:59
 */

public class P141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;

        }

        ListNode runner = head;
        ListNode walker = head;

        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }

    //链表环中的节点数目
    public int numInCycle(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode runner = head;
        ListNode walker = head;
        ListNode recorder = null;
        //判断是否有环，并且找到环中的任何一个节点
        while (runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
            if (walker == runner) {
                recorder = runner;
                break;
            }
        }
        if (recorder == null) {
            return 0;
        }

        // 环中节点的数量
        int count = 1;
        while (recorder != walker.next) {
            count++;
            walker = walker.next;
        }
        return count;
    }

    //找到链表环的入口
    public ListNode findEntranceNode(ListNode head) {
        if (head == null) {
            return null;
        }

        int count = numInCycle(head);
        System.out.println("num:" + count);
        if (count == 0) {
            return null;
        }

        ListNode faster = head;
        ListNode tailer = head;

        while (count-- > 0) {
            faster = faster.next;
        }

        while (faster != tailer) {
            faster = faster.next;
            tailer = tailer.next;

        }
        return faster;
    }

    public static void main(String[] args) {
        P141_LinkedListCycle cycle = new P141_LinkedListCycle();
        ListNode head = null;
        ListNode result = cycle.findEntranceNode(head);
        System.out.println(result == null);

        head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        result = cycle.findEntranceNode(head);
        System.out.println(result == null);

        head.next.next.next.next.next = head.next;
        result = cycle.findEntranceNode(head);
        System.out.println(result == head.next);
    }

}
