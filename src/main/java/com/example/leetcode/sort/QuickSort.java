package com.example.leetcode.sort;

/**
 * @author yu dong qin
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @date 2019/5/25 22:35
 */
public class QuickSort {
    /**
     * @return int[]
     * @Description
     * @Param [array, low, high]
     **/
    public static int[] quickSort(int[] array, int low, int high) {
        if (low > high) {
            return array;
        }
        int pivot = partition(array, low, high);
        quickSort(array, low, pivot - 1);
        quickSort(array, pivot + 1, high);
        return array;
    }

    /**
     * @return int
     * @Description 分区
     * @Param [array, low, high]
     **/
    private static int partition(int[] array, int low, int high) {
        int left = low;
        int right = high;
        int base = array[low];
        //while这里的作用是将小于、大于基准点的元素，分别划分到基准点的两侧
        while (left < right) {
            while (array[left] <= base) {
                left++;
            }
            while (array[right] > base) {
                right--;
            }
            if (left < right) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }
        //将基准点归位（left == rigth时表明，基准点找到）
        array[low] = array[right];
        array[right] = base;
        return right;
    }
}
