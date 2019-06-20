package com.example.leetcode.stringmatching;

/**
 * @Description:Knuth-Morris-Pratt算法 参考资料：
 * https://github.com/henlix/string-pattern-matching/blob/master/src/org/sopt/string/strategy/impl/KMP.java
 * https://www.cnblogs.com/en-heng/p/5091365.html
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * @Auther: 覃钰栋
 * @Date: 2019/6/20 16:53
 */
public class KMP {

    //搜索
    public int search(String text, String pattern) {
        int[] array = fail(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = array[j];
            }
            if (j == pattern.length()) {
                return i - pattern.length();
            }
        }
        return -1;
    }


    //失配函数
    private int[] fail(String pattern) {
        int m = pattern.length();
        int[] array = new int[m + 1];
        int i = 1;
        int j = 0;
        array[0] = -1;

        while (i < m) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                array[i] = j;
            } else {
                j = array[j];
            }
        }
        return array;

    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String p = "abcac";
        String t = "ababcabcacbab";
        int index = kmp.search(t, p);
        System.out.println(index);

    }
}
