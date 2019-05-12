package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 141.环形链表（链表中环检测）
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //慢指针
        ListNode slow = head;
        //快指针
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? false : fast == slow;
    }
}
