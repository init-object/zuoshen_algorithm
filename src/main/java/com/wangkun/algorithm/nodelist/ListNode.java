package com.wangkun.algorithm.nodelist;

/**
 * @author wk
 * @Date: 2022/3/14
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val,
             ListNode next) {
        this.val = val;
        this.next = next;
    }
}
