package com.example.leetcode.sort;

/**
 * @author yu dong qin
 * @ClassName: SelectionSort
 * @Description: 选择排序（本质是交换下标）
 * @date 2019/5/23 22:21
 */
public class SelectionSort {

    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length -1; i++) {
            int k = i;
            for (int j = k + 1; j < array.length; j++) {
                /** 原理：每一趟从待排序的记录中选出最小的元素，
                 * 顺序放在已排好序的序列最后，直到全部记录排序完毕
                 * */
                if (array[j] < array[k]){
                    k = j;
                }
            }

            //交换数据
            if (i != k){
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }
        return array;
    }
}
