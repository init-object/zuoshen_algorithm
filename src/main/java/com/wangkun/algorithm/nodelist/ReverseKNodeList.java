package com.wangkun.algorithm.nodelist;

/**
 * @author wk
 * @Date: 2022/3/14
 * @Description:
 */
public class ReverseKNodeList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next  = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode = reverseKGroup(listNode, 2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head,
                                  int k) {
        if (head == null) {
            return head;
        }
        ListNode end = getEndNode(head, k);
        if (end == null) {
            return head;
        }
        ListNode start = head;
        head = end;

        reverseNodeList(start, end);
        ListNode lastStart = start;
        while (lastStart.next != null) {
            start = lastStart.next;
            end = getEndNode(start, k);
            if (end == null) {
                return head;
            }
            reverseNodeList(start, end);
            lastStart.next = end;
            lastStart = start;
        }


        return head;

    }

    public static ListNode getEndNode(ListNode start,
                               int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    public static void reverseNodeList(ListNode start,
                                ListNode end) {
        ListNode head = start;
        ListNode pre = null;
        ListNode next = null;
        end = end.next;
        while (start != end) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        head.next = end;

    }
}
