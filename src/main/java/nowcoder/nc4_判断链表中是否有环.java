package nowcoder;

import myUtils.ListNode;

/**
 * 链表是否有环, 环的入口
 * Created by WangSai on 2021/8/8
 */
public class nc4_判断链表中是否有环 {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);

        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = t3;

        nc4_判断链表中是否有环 nc4 = new nc4_判断链表中是否有环();

        ListNode node = nc4.findEntranceNode(t1);
        System.out.println(node.val);

    }

    public ListNode findEntranceNode(ListNode head) {
        // 链表是否有环，如果有环返回环中的任意节点
        ListNode nodeInCycle = nodeInCycle(head);
        if (null == nodeInCycle) {
            return null;
        }

        // 统计环中的节点数量
        int countNodeInCycle = countNodeInCycle(nodeInCycle);

        // 获取环的入口节点
        return getListNode(head, countNodeInCycle);
    }

    private ListNode getListNode(ListNode head, int countNodeInCycle) {
        ListNode f = head;
        ListNode s = head;
        while (countNodeInCycle-- > 0) {
            f = f.next;
        }
        while (s != f) {
            f = f.next;
            s = s.next;
        }
        return s;
    }

    public int countNodeInCycle(ListNode node) {
        int count = 1;
        ListNode cur = node.next;

        while (cur != node) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public ListNode nodeInCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && s != null) {
            f = f.next;
            if (null == f) {
                return null;
            }

            f = f.next;
            s = s.next;
            if (s == f) {
                return f;
            }
        }
        return null;
    }

}
