package com.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author yu dong qin
 * @ClassName: Bsearch2
 * @Description:
 * @date 2019/5/27 22:48
 */
public class Bsearch2 {
    //查找第一个等于给定值的元素
    public static int bsearch(int[] array, int value) {
        int low = 0;
        int high = array.length-1;
        int mid = getIndex(array, value, low, high);
        return mid;
    }

    private static int getIndex(int[] array, int value, int low, int high) {
        while (low <= high){
            int mid = low+ ((high - low) >> 1);
            if (array[mid] == value){
                return mid;
            }else if (array[mid] > value){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,4,4,5,6,7,8,9};
        System.out.println(bsearch(array, 4));
    }
}
