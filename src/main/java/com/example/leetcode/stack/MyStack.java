package com.example.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yu dong qin
 * @ClassName: 动态数据实现栈
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MyStack<E> {
    private List<E> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * 入栈
     *
     * @param e
     * @return
     */
    public void push(E e) {
        data.add(e);
    }

    /**
     * 返回栈顶端的元素
     *
     * @return
     */
    public E peerk() {
        if (isEmpty()) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    /**
     * 返回栈顶端的元素,并删除
     *
     * @return
     */
    public E pop() {
        E e = peerk();
        data.remove(e);
        return e;
    }

    /**
     * 返回最靠近顶端的目标元素到顶端的距离
     * 栈中没有目标元素e时，返回-1
     *
     * @param e
     * @return
     */
    public int search(E e) {
        int i = data.lastIndexOf(e);
        if (i >= 0) {
            return data.size() - i;
        }
        return -1;
    }

    /**
     * 判断stack是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
