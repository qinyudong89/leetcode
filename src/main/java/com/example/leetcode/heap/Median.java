package com.example.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yu dong qin
 * @ClassName: Median
 * @Description: 求中位数
 * @date 2019/6/6 20:46
 */
public class Median {
    //堆的大小
    private int count;
    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //PriorityQueue默认实现的是小顶堆，因此大顶堆要给定一个Comparator
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    /**
     * 添加元素
     *
     * @param num
     */
    public void put(Integer num) {
        count++;
        //第一次两个堆的为空时
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }

        /*
           如果新加入的数据小于等于大顶堆的堆顶元素，我们就将这个新数据插入到大顶堆；
           否则，我们就将这个新数据插入到小顶堆。
         */
        if (num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        //保持maxHeap的长度为（偶数：size/2,奇数：size/2+1）
        int mid = count >> 1;
        if (maxHeap.size() > mid) {
            int diff = maxHeap.size() - mid;
            move(maxHeap, minHeap, diff);
        }
        if (minHeap.size() > mid) {
            int diff = minHeap.size() - mid;
            move(minHeap, maxHeap, diff);
        }
    }

    /**
     * 从src移动count个元素至target
     *
     * @param src
     * @param target
     * @param count
     */
    private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> target, int count) {
        for (int i = 0; i < count; i++) {
            target.offer(src.poll());
        }
    }

    /**
     * 获取中位数（偶数取n/2,奇数：n/2+1）
     *
     * @return
     */
    public int getMedian() {
        return maxHeap.peek();
    }
}
