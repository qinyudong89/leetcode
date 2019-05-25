package com.example.leetcode.sort;

/**
 * @author yu dong qin
 * @ClassName: SellSort
 * @Description: 希尔排序
 * @date 2019/5/22 23:09
 */
public class SellSort {
    public static int[] shellSort(int[] array) {
        int number = array.length / 2;
        int i;
        int j;
        int temp;
        while (number >= 1) {
            for (i = number; i < array.length; i++) {
                temp = array[i];
                j = i - number;
                //需要注意的是，這裡array[j] < temp將會使數组從大到小排序。
                while (j >= 0 && array[j] < temp) {
                    array[j + number] = array[j];
                    j = j - number;
                }
                array[j + number] = temp;
            }
            number = number / 2;
        }
        return array;
    }
}
