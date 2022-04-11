package com.wangkun.algorithm.stackqueue;

import java.util.Stack;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description:
 */
public class StackGetMin<T extends Comparable<T>> {
    private Stack<T> stackData;
    private Stack<T> stackMin;

    public StackGetMin() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(T value) {
        stackData.push(value);
        if (stackMin.isEmpty()) {
            stackMin.push(value);
        }
        if (value.compareTo(getMin()) <= 0) {
            stackMin.push(value);
        }
    }

    public T pop() {
        T value = stackData.pop();
        if (value.compareTo(getMin()) <= 0) {
            stackMin.pop();
        }
        return value;

    }
    public T getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stackMin.peek();
    }

    public boolean isEmpty() {
        return stackData.isEmpty();
    }
}
