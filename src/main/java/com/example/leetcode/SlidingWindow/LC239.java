package com.example.leetcode.SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/8 0:04
 */
public class LC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // 若最新窗口的左边界大于等于窗口长度，则移除最左边的元素
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                System.out.println(i+" "+k+" "+deque.peekFirst());
                deque.pollFirst();
            }
            if (i + 1 >= k) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        LC239 lc239 = new LC239();
        int[] result = lc239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
