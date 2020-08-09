package com.example.leetcode.linked.removeNth;

import com.example.leetcode.linked.ListNode;

/**
 * @author yu dong qin
 * @ClassName: 19. 删除链表的倒数第N个节点(一次遍历算法)
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快指针（比慢指针快n步）
        ListNode fast = head;
        //慢指针
        ListNode slow = head;
        int i = 0;
        while (i < n) {
            fast = fast.next;
            i++;
        }

        //n=size 链表的长度时，需特别处理
        if (fast == null) {
            return head.next;
        }

        //获取n后面的节点(fast.next == null时，slow.next刚好走到n节点)
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //删除n处的节点
        slow.next = slow.next.next;
        return head;
    }
}
