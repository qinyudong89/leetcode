package com.example.leetcode.stack;

import java.util.Stack;

/**
 * @author yu dong qin
 * @ClassName: 155. 最小栈
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        // 如果x<=min,
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // 如果删除栈项的元素，会导致最小值发生变化时。将当前栈中最小的值赋于min
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */