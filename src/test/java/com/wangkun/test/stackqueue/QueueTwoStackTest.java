package com.wangkun.test.stackqueue;

import com.wangkun.algorithm.stackqueue.QueueTwoStack;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description:
 */
public class QueueTwoStackTest {
    public static void main(String[] args) {
        QueueTwoStack<Integer> queue = new QueueTwoStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("queue 1:" + queue.poll());
        System.out.println("queue 2:" + queue.poll());
        System.out.println("queue 3:" + queue.poll());
    }
}
