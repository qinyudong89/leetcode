package com.example.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author yu dong qin
 * @ClassName: Merge
 * @Description:使用小顶堆合并两个有序数组
 * @date 2019/6/8 13:35
 */
public class Merge {

    public static int[] merge(int[] x, int[] y) {
        int len = x.length + y.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int k = 0, i = 0, j = 0; k < len; k++) {
            if (i >= x.length) {
                minHeap.offer(y[j++]);
            } else if (j >= y.length) {
                minHeap.offer(x[i++]);
            } else if (x[i] > y[j]) {
                minHeap.offer(y[j++]);
            } else {
                minHeap.offer(x[i++]);
            }
        }

        int[] result = new int[len];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll();
            i++;
        }
        return result;
    }
}
