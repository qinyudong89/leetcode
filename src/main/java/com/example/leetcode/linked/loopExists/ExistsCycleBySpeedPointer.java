package com.example.leetcode.linked.loopExists;

import com.example.leetcode.linked.ListNode;

public class ExistsCycleBySpeedPointer {
    /**
     * 通过快慢指针
     * 时间复杂度：O(n)
     * 窝里复杂度：O(1)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
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
