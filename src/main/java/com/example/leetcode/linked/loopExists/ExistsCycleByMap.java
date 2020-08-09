package com.example.leetcode.linked.loopExists;

import com.example.leetcode.linked.ListNode;

import java.util.HashSet;
import java.util.Set;

public class ExistsCycleByMap {
    /**
     * 通过Map
     * 1、在遍历ListNode时，将val作为key
     * 2、如果Key重复，则说明存在环
     * 时间复杂度：O(n)
     * 窝里复杂度：O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
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
}
