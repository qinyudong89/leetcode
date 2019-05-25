package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 设计单向链表
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class SingleLinkedList {
    int size;
    Node head;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public SingleLinkedList() {
    }

    /**
     * Get the value of the k-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            //从头遍历至index节点
            int i = 0;
            Node cur = head;
            while (index != i) {
                cur = cur.next;
                i++;
            }
            return cur.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        //1、创建新节点
        Node newHead = new Node(val);
        Node cur = head;
        if (cur == null) {
            head = newHead;
        } else {
            //当前节点作为新节点的next
            newHead.next = cur;
            //当新节点作为头节点
            head = newHead;
            cur = null;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
        } else {
            Node cur = head;
            //遍历到尾节点
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            //从头遍历至index-1节点
            int i = 0;
            Node cur = head;
            while (i < (index - 1)) {
                cur = cur.next;
                i++;
            }
            Node newNode = new Node(val);
            newNode.next = cur.next;
            cur.next = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node cur = head;
        if (index == 0) {
            head = cur.next;
        } else {
            //获取index的上一个节点
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            Node prev = cur;
            prev.next = cur.next.next;
        }
        cur = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

