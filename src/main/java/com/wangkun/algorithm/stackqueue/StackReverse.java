package com.wangkun.algorithm.stackqueue;

import java.util.Stack;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description: 仅用递归操作和栈操作逆序一个栈
 */
public class StackReverse {
    public static <E> void reverse(Stack<E> stack) {
        if (stack.isEmpty()) {
            return;
        }
        E element = getAndRemoveLastElement(stack);
        System.out.println(element);
        reverse(stack);
        stack.push(element);
    }

    private static <E> E getAndRemoveLastElement(Stack<E> stack){
        E value = stack.pop();
        if (stack.isEmpty()) {
            return value;
        }
        E element = getAndRemoveLastElement(stack);
        stack.push(value);
        return element;
    }

}
