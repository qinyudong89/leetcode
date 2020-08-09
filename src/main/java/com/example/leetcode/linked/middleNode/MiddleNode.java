package com.example.leetcode.linked.middleNode;

import com.example.leetcode.linked.ListNode;

/**
 * @author yu dong qin
 * @ClassName: 876. 链表的中间结点
 * @Description:
 * 题目：
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 解答思路：
 * 定义两个指针fast和slow。slow一次遍历一个节点，fast一次遍历两个节点，
 * 由于fast的速度是slow的两倍，所以当fast遍历完链表时，slow所处的节点就是链表的中间节点。
 * @date
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
       if (head == null || head.next == null){
           return head;
       }
       //慢指针
        ListNode slow = head;
       //快指针
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

}
