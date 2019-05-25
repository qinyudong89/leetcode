package com.example.leetcode.sort;

/**
 * @author yu dong qin
 * @ClassName: InsertSort
 * @Description: 插入排序
 * @date 2019/5/22 22:16
 */
public class InsertSort {

    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            //temp通过与它前面的元素对比，找到自己的位置
            while (j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
            }
            //temp找到位置后，交换数据
            array[j + 1] = temp;
        }
        return array;
    }
}
