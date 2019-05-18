package com.example.leetcode.queue;

/**
 * @author yu dong qin
 * @ClassName: ArrayQueue
 * @Description: 数组实现队列
 * @date
 */

public class ArrayQueue<E> {
    /** 数组 */
    private Object[] elements;
    /** 数组大小 */
    private int length;
    /** 表示队头下标 */
    private int head = 0;
    /** 表示队尾下标 */
    private int tail = 0;

    public ArrayQueue(int capacity) {
        elements = new Object[capacity];
        length = capacity;
    }

    /**
     * @return boolean
     * @Description 入列
     * @Param [e]
     **/
    public boolean enqueue(E e) {
        if (tail == length) {
            if (head == 0) {
                return false;
            }
            /*
             1、数据搬移(解决在多次入列、出列后；由于head,tail的后移，
             即使数组有空间；也无法再存在元素的问题)
             2、触发数据搬移的因素为，tail等于数组的长度，且head不为0时。
             原因是减少数据搬移操作，只有必要时才执行
             */
            for (int i = head; i < tail; i++) {
                elements[i - head] = elements[i];
            }
            tail -= head;
            head = 0;
        }
        elements[tail] = e;
        tail++;
        return true;
    }

    /**
     * @return E
     * @Description 出列
     * @Param []
     **/
    public E dequeue() {
        if (head == tail) {
            return null;
        }
        E e = (E) elements[head];
        ++head;
        return e;
    }
}
