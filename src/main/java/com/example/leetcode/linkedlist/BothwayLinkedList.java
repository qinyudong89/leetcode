package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 设计双向链表
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class BothwayLinkedList<E> {
    //头节点
    Node first;
    //最后节点
    Node last;
    //链表长度
    int size;

    /**
     * 元素从头节点插入
     *
     * @param e
     */
    public void addFirst(E e) {
        Node p = first;
        Node cur = new Node(null, e, p);
        first = cur;
        if (p == null) {
            last = cur;
        } else {
            p.prev = cur;
        }
        size++;
    }

    /**
     * 元素从尾节点插入
     *
     * @param e
     */
    public void addLast(E e) {
        Node p = last;
        Node cur = new Node(last, e, null);
        last = cur;
        if (p == null) {
            first = cur;
        } else {
            p.next = cur;
        }
        size++;
    }

    /**
     * 删除指定元素
     *
     * @param o
     * @return
     */
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        //将x的前节点的后继指针
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        //将x的后继节点的前节点指针
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    /**
     * 获取index的元素
     *
     * @param index
     * @return
     */
    public Node<E> get(int index) {
        checkIndex(index);
        //二分查找
        if (index < size >> 1) {
            Node<E> p = first;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p;
        } else {
            Node<E> p = last;
            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }
            return p;
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    class Node<E> {
        //值
        E item;
        //前节点
        Node prev;
        //后继节点
        Node next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
