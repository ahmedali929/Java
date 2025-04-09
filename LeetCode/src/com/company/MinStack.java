package com.company;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minimumStack;

    public MinStack() {
        stack = new Stack<>();
        minimumStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minimumStack.isEmpty() || value <= minimumStack.peek()) {
            minimumStack.push(value);
        }
    }

    public void pop() {
        int poppedValue = stack.pop();
        if (poppedValue == minimumStack.peek()) {
            minimumStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minimumStack.peek();
    }


}
