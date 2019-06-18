package Problems;

import java.util.Stack;

/**
 * Created by WangSai on 2019-06-18 23:46
 *
 * 题目链接：https://leetcode.com/problems/min-stack/
 *
 * 题目描述：
 *  Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *  push(x) -- Push element x onto stack.
 *  pop() -- Removes the element on top of the stack.
 *  top() -- Get the top element.
 *  getMin() -- Retrieve the minimum element in the stack.
 *  Example:
 *  MinStack minStack = new MinStack();
 *  minStack.push(-2);
 *  minStack.push(0);
 *  minStack.push(-3);
 *  minStack.getMin();   --> Returns -3.
 *  minStack.pop();
 *  minStack.top();      --> Returns 0.
 *  minStack.getMin();   --> Returns -2.
 */

public class P155_MinStack {

    Stack<Integer> minNumStack;
    Stack<Integer> allNumStack;

    public P155_MinStack() {
        minNumStack = new Stack<Integer>();
        allNumStack = new Stack<Integer>();
    }

    public void push(int x) {
        allNumStack.push(x);
        if (minNumStack.isEmpty()) {
            minNumStack.push(x);
            return;
        }
        int minNum = minNumStack.peek();
        if (x < minNum) {
            minNumStack.push(x);
        } else {
            minNumStack.push(minNum);
        }
    }

    public void pop() {
        allNumStack.pop();
        minNumStack.pop();
    }

    public int top() {
        return allNumStack.peek();
    }

    public int getMin() {
        return minNumStack.peek();
    }
}
