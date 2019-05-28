package com.example.leetcode.bsearch;

/**
 * @Description:33. 搜索旋转排序数组
 * @Auther: 覃钰栋
 * @Date: 2019/5/28 15:02
 */
public class ScrewArray {

    public static int search(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] == target) {
                return mid;
            }

            //情况一、如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组
            if (array[low] <= array[mid]) {
                if (target < array[mid] && target >= array[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            //情况二、如果尾元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
            if (array[high] >= array[mid]) {
                if (target > array[mid] && target <= array[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
