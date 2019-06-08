package com.example.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author yu dong qin
 * @ClassName: TopK
 * @Description: 查找前K的大数据
 * @date 2019/6/6 16:52
 */
public class TopK {

    public static int[] topk(int[] array, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        //1、构建k大小的小顶堆
        for (int i : array) {
            if (minHeap.size() < k) {
                minHeap.offer(i);
            } else {
                //比堆顶大的，则存入
                if (i > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(i);
                }
            }
        }
        //2、minHeap就是前K的大数据
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll();
            i++;
        }
        return result;
    }
}
