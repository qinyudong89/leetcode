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
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        //1、构建k大小的堆
        for (int i : array) {
            if (queue.size() < k) {
                queue.offer(i);
            } else {
                //比堆顶大的，则存入
                if (i > queue.peek()) {
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        //2、queue就是前K的大数据
        int[] result = new int[k];
        for (int j = 0; j < k && !queue.isEmpty(); j++) {
            result[j] = queue.poll();
        }
        return result;
    }
}
