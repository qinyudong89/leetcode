package com.example.leetcode.linked;

public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        ListNode prevNode = new ListNode(0);    //Node situated before the two to-be-swapped nodes
        prevNode.next = head;                   //Starting before head
        ListNode newHead = prevNode;            //Storing a reference for returning

        while(prevNode.next!=null && prevNode.next.next!=null){
            //Declare (...[prev]-->[frist]-->[second]-->[next]...)
            ListNode frist = prevNode.next;
            ListNode second = frist.next;
            ListNode nextNode = second.next;

            //Swap(...[prev]-->[second]<--[frist]   [next]...)
            prevNode.next = second;
            second.next = frist;
            frist.next = nextNode;

            //Move (...[...]-->[second]-->[frist/prev]-->[next]...)
            prevNode = frist;
        }
        return newHead.next;
    }

}
