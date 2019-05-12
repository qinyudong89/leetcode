package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 243.回文链表
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        //找中间节点（slow）
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转
        ListNode cur = null;
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = cur;
            cur = slow;
            slow = temp;
        }

        //判断是否是回文
        while(head != null){
            if(head.val != cur.val){
                return false;
            }
            head = head.next;
            cur = cur.next;
        }
        return true;
    }
}
