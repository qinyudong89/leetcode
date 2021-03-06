package com.example.leetcode.stringmatching;

/**
 * @author yu dong qin
 * @ClassName: BruteForce
 * @Description: 暴力算法
 * @date 2019/6/9 17:00
 */
public class BruteForce {

    /**
     * 查找出pattern在text中第一字首次出现的下标
     *
     * @param text    文本
     * @param pattern 子串
     * @return
     */
    public static int bruteForce(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        //每次对比次数为：n - m + 1次
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            //第一个字符如果匹配，则继续往后比较
            while (j < m && pattern.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            //j==m则说明已经找到匹配的字符串
            if (j == m) {
                return i;
            }
        }
        return -1;
    }
}
