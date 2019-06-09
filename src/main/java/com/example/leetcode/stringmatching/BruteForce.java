package com.example.leetcode.stringmatching;

/**
 * @author yu dong qin
 * @ClassName: BruteForce
 * @Description: 暴力算法
 * @date 2019/6/9 17:00
 */
public class BruteForce {

    /**
     * 查找出pattern在target中第一字首次出现的下标
     *
     * @param target  主串
     * @param pattern 子串
     * @return
     */
    public static int bruteForce(String target, String pattern) {
        char[] t = target.toCharArray();
        char[] p = pattern.toCharArray();
        int n = t.length;
        int m = p.length;
        //每次对比次数为：n - m + 1次
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            //第一个字符如果匹配，则继续往后比较
            while (j < m && p[j] == t[i + j]) {
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
