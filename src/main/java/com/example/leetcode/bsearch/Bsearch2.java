package com.example.leetcode.bsearch;

/**
 * @author yu dong qin
 * @ClassName: Bsearch2
 * @Description:查找第一个等于给定值的元素
 * @date 2019/5/27 22:48
 */
public class Bsearch2 {

    public static int bsearch(int[] array, int value) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (array[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
