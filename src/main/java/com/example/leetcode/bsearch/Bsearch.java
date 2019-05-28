package com.example.leetcode.bsearch;

/**
 * @Description:二分查找
 * @Auther: 覃钰栋
 * @Date: 2019/5/27 17:42
 */
public class Bsearch {

    public static int bsearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            //int mid = (high - low)/2;改成下面的写法，是避免当high、low都比较大的时候溢出
            int mid = low + ((high - low) >> 1);

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
