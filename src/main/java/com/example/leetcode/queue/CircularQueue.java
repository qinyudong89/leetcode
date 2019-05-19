package com.example.leetcode.queue;

/**
 * @author yu dong qin
 * @ClassName: CircularQueue
 * @Description: 循环队列（优点：当队列tail等于队列长度时，避免数据搬移
 *                          缺点：队列为一个数组的存在空间）
 * tail计算公式：tail = (tail + 1) % length;
 * head计算公式：head = (head + 1) % length;
 * @date 2019/5/19 14:48
 */
public class CircularQueue<E> {
    /** 数组 */
    private Object[] elements;
    /** 数组大小 */
    private int length;
    /** 表示队头下标 */
    private int head = 0;
    /** 表示队尾下标 */
    private int tail = 0;

    public CircularQueue(int capacity) {
        elements = new Object[capacity];
        this.length = capacity;
    }

    /**
     *
     * @Description  入列
     * @Param [e]
     * @return boolean
     **/
    public boolean enqueue(E e){
        //判断队列是否已满
        if ((tail + 1)%length == head){
            return false;
        }
        elements[tail] = e;
        tail++;
        return true;
    }

    /**
     *
     * @Description  出列
     * @Param []
     * @return E
     **/
    public E dequeue(){
        //判断队列是否为空
        if (head == tail){
            return null;
        }
        E e = (E) elements[head];
        //重新计算head的位置
        head = (head +1)%length;
        return e;
    }
}
