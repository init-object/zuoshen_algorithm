package com.wangkun.test.stackqueue;

import com.wangkun.algorithm.stackqueue.StackReverse;

import java.util.Stack;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description:
 */
public class StackReverseTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("before:" + stack);
        StackReverse.reverse(stack);
        System.out.println("reverse:" + stack);
    }
}
