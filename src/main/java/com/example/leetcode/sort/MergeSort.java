package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author yu dong qin
 * @ClassName: MergeSort
 * @Description: 归并排序
 * @date 2019/5/25 10:09
 */
public class MergeSort {
    //合并
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = decomposition(array, 0, mid);
        int[] right = decomposition(array, mid, array.length);
        return mergeSort(mergeSort(left), mergeSort(right));
    }

    //比较排序
    public static int[] mergeSort(int[] left, int[] right) {
        int[] newArray = new int[left.length + right.length];
        for (int i = 0, L = 0, R = 0; i < newArray.length; i++) {
            if (L >= left.length) {
                newArray[i] = right[R++];
            } else if (R >= right.length) {
                newArray[i] = left[L++];
            } else if (left[L] > right[R]) {
                newArray[i] = right[R++];
            } else {
                newArray[i] = left[L++];
            }
        }
        return newArray;
    }

    /**
     * 将数组拆分成两个数组
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] decomposition(int[] array, int start, int end) {
        if (array.length < 2) {
            return array;
        }

        int[] newArray = new int[end - start];
        for (int i = start; i < end; i++) {
            newArray[i - start] = array[i];
        }
        return newArray;
    }
}
