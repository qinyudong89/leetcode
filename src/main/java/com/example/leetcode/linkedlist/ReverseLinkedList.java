package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 反转链表(遍历法)
 * @Description: 设置三个节点pre、cur、next
 * （1）每次查看cur节点是否为NULL，如果是，则结束循环，获得结果
 * （2）如果cur节点不是为NULL，则先设置临时变量next为cur的下一个节点
 * （3）让cur的下一个节点变成指向pre，而后pre移动cur，cur移动到next
 * （4）重复（1）（2）（3）
 * @date
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //前指针节点
        ListNode prev = null;
        //当前指针节点
        ListNode curr = head;
        //每次循环都将当前节点的next指向它前面的节点，然后当前节点和前节点后移
        while (curr != null) {
            //临时节点，暂存当前节点的下一节点，用于后移
            ListNode nextTemp = curr.next;
            //将当前节点的next指向它前面的节点(反转)
            curr.next = prev;
            //前指针后移
            prev = curr;
            //当前指针后移
            curr = nextTemp;
        }
        return prev;
    }

}
