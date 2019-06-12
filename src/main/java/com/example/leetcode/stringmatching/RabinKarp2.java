package com.example.leetcode.stringmatching;

/**
 * @Description:Rabin-Karp算法
 * @Auther: 覃钰栋
 * @Date: 2019/6/12 14:41
 */
public class RabinKarp2 {
    // d是进制
    public final static int d = 256;
    //质数
    public final static int q = 9001;

    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int p = 0;
        int t = 0;
        int h = 1;
        //1、h的值为“pow(d, M-1)%q”
        for (int i = 0; i < m - 1; i++) {
            h = (d * h) % q;
        }

        //2、计算pattern的哈希值，及text第一个子串的哈希值
        for (int i = 0; i < m; i++) {
            t = (d * t + text.charAt(i)) % q;
            p = (d * p + pattern.charAt(i)) % q;
        }
        //3、将text中的每个长度为m的子串的哈希值，与pattern的哈希值比较
        for (int i = 0; i <= n - m; i++) {
            if (t == p) {
                int j = 0;
                while (j < m && (pattern.charAt(j) == text.charAt(i + j))) {
                    j++;
                }
                //j==m则说明已经找到匹配的字符串
                if (j == m) {
                    return i;
                }
            }

            //4、计算下一个子串的哈希值
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t += q;
                }
            }
        }
        return -1;
    }
}
