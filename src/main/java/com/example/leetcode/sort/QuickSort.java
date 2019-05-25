package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author yu dong qin
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @date 2019/5/25 17:31
 */
public class QuickSort {
    
    public static int[] quickSort(int[] array, int low, int high){
        if (low > high){
            return array;
        }
        /** 作用在于找到大于基准数 */
        int left = low;
        /** 作用在于找到小于基准数 */
        int right = high;
        /** 基准元素 */
        int base = array[low];

        /**
         * 1、分区（小于基准数的放在左边，大于基准数的放在右边）
         * 注：当left == right时表明找到基准元素的位置
         * */
        while (left < right){
            /** 从右向左遍历，直到找到小于基准元素*/
            while ( array[right] >= base && left < right){
                right--;
            }

            /** 从左向右遍历，直到找到大于基准元素 */
            while (array[left] <= base && left < right){
                left++;
            }
            if (left < right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }
        /** 2、将基准元素归位(此时left == right 说明已经找到基准元素的位置) */
        array[low] = array[left];
        array[left] = base;

        /** 遍历排序右边数组 */
        quickSort(array, low, right - 1);
        /** 遍历排序左边数组 */
        quickSort(array, right + 1, high);
        return array;
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println(Arrays.toString(quickSort(array, 0, array.length -1)));
    }
}
