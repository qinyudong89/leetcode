package com.example.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yu dong qin
 * @ClassName: 141.环形链表（链表中环检测）
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class LinkedListCycle {

    /**
     * 解法一：通过Map
     * 1、在遍历ListNode时，将val作为key
     * 2、如果Key重复，则说明存在环
     * 时间复杂度：O(n)
     * 窝里复杂度：O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }

    /**
     * 解法二：通过快慢指针
     * 时间复杂度：O(n)
     * 窝里复杂度：O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
