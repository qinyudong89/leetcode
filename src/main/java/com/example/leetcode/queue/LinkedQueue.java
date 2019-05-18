package com.example.leetcode.queue;

/**
 * @author yu dong qin
 * @ClassName: LinkedQueue
 * @Description: 基于链表实现的队列
 * @date 2019/5/18 21:51
 */
public class LinkedQueue<E> {
    /** 队首 */
    private Node<E> head;
    /** 队尾 */
    private Node<E> tail;

    /**
     *
     * @Description  入列
     * @Param [e]
     * @return void
     **/
    public void enqueue(E e) {
        Node newNode = new Node<>(e, null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    /**
     *
     * @Description  出列
     * @Param []
     * @return E
     **/
    public E dequeue() {
        if (head == null) {
            return null;
        }
        E item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return item;
    }

    private static class Node<E> {
        //数据
        E item;
        //后继节点
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }
}
