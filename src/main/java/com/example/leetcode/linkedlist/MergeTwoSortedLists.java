package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 21.合并两个有序链表
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode newNode ;
       if(l1.val < l2.val){
            newNode = l1;
            newNode.next = mergeTwoLists(l1.next, l2);
       }else {
           newNode = l2;
           newNode.next = mergeTwoLists(l1, l2.next);
       }
       return newNode;
    }

    public static void main(String[] args) {
       int j = 0;
       int count = 3;
       while(j < count-1){
           j++;
       }
        System.out.println(j);
    }
}
