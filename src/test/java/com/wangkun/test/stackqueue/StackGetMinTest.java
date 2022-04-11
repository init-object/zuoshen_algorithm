package com.wangkun.test.stackqueue;

import com.wangkun.algorithm.stackqueue.StackGetMin;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description:
 */
public class StackGetMinTest {
    public static void main(String[] args) {
        StackGetMin<Integer> stack = new StackGetMin<>();
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(1);

        System.out.println("stack min :" + stack.getMin());
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println("stack :" + sb);

    }
}
