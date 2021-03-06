package com.example.leetcode.bsearch;

/**
 * @Description:查找最后一个小于等于给定值的元素
 * @Auther: 覃钰栋
 * @Date: 2019/5/28 11:30
 */
public class Bsearch5 {
    public static int bsearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == high || array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
