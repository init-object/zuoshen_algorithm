package com.wangkun.algorithm.stackqueue;

import java.util.Stack;

/**
 * @author wk
 * @Date: 2021/9/16
 * @Description:
 */
public class QueueTwoStack<T> {
    private Stack<T> stackPush;
    private Stack<T> stackPop;

    public QueueTwoStack() {
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }
    private void pushToPop(){
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(T value) {
        stackPush.push(value);
        pushToPop();
    }

    public T poll() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.pop();
    }

    public T peek() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

}
