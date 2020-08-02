package com.example.leetcode.linkedlist;

/**
 * @author yu dong qin
 * @ClassName: 21.合并两个有序链表
 * @Description: (这里用一句话描述这个类的作用)
 * @date
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        终止条件：当两个链表都为空时，表示我们对链表已合并完成。
        如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。（调用递归）
         */
        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
